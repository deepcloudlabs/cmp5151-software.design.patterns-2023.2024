package com.example.hr.adapter;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import com.example.hr.document.EmployeeDocument;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.repository.EmployeeDocumentRepository;
import com.example.hr.repository.EmployeeRepository;

@Repository
@ConditionalOnProperty(name = "persistencePlatform", havingValue = "mongodb")
public class EmployeeRepositoryMongoAdapter implements EmployeeRepository {
	private final EmployeeDocumentRepository employeeDocumentRepository;
	private final ModelMapper modelMapper;

	public EmployeeRepositoryMongoAdapter(EmployeeDocumentRepository employeeDocumentRepository,
			ModelMapper modelMapper) {
		this.employeeDocumentRepository = employeeDocumentRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public Optional<Employee> findEmployeeByIdentity(TcKimlikNo identity) {
		var employeeDocument = employeeDocumentRepository.findById(identity.getValue());
		return employeeDocument.map(document -> modelMapper.map(document, Employee.class));
	}

	@Override
	public boolean exists(TcKimlikNo identityNo) {
		return employeeDocumentRepository.existsById(identityNo.getValue());
	}

	@Override
	public Employee persist(Employee employee) {
		var employeeDocument = modelMapper.map(employee, EmployeeDocument.class);
		var savedEmployeeDocument = employeeDocumentRepository.save(employeeDocument);
		return modelMapper.map(savedEmployeeDocument, Employee.class);
	}

	@Override
	public Optional<Employee> remove(TcKimlikNo identity) {
		var firedEmployeeDocument = employeeDocumentRepository.findById(identity.getValue());
		EmployeeDocument document = firedEmployeeDocument.get();
		employeeDocumentRepository.delete(document);
		return Optional.ofNullable(modelMapper.map(document, Employee.class));
	}

}
