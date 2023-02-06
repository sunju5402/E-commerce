package com.zb.userapi.service;

import com.zb.userapi.domain.SignUpForm;
import com.zb.userapi.domain.model.Customer;
import com.zb.userapi.domain.repository.CustomerRepository;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpCustomerService {

	private final CustomerRepository customerRepository;

	public Customer signUp(SignUpForm form) {
		return customerRepository.save(Customer.from(form));
	}

	public boolean isEmailExist(String email) {
		return customerRepository.findByEmail(email.toLowerCase(Locale.ROOT))
			.isPresent();
	}

//	@Transactional
//	public void verifyEmail(String email, String code) {
//		Customer customer = customerRepository.findByEmail(email)
//			.orElseThrow(() -> new CustomException(NOT_FOUND_USER));
//
//		if (customer.isVerify()) {
//			throw new CustomException(ALREADY_VERIFY);
//		} else if (!customer.getVerificationCode().equals(code)) {
//			throw new CustomException(WRONG_VERIFICATION);
//		} else if (customer.getVerifyExpiredAt().isBefore(LocalDateTime.now())) {
//			throw new CustomException(EXPIRE_CODE);
//		}
//		customer.setVerify(true);
//	}
//
//	@Transactional
//	public LocalDateTime changeCustomerValidateEmail(Long customerId, String verificationCode) {
//		Customer c = customerRepository.findById(customerId)
//			.orElseThrow(() -> new CustomException(NOT_FOUND_USER));
//
//		c.setVerificationCode(verificationCode);
//		c.setVerifyExpiredAt(LocalDateTime.now().plusDays(1));
//		return c.getVerifyExpiredAt();
//	}
}