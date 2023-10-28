import com.example.random.service.RandomNumberGenerator;
import com.example.random.service.business.StandardRandomNumberGenerator;

module com.example.random {
	exports com.example.random.service;
	provides RandomNumberGenerator with StandardRandomNumberGenerator;
}