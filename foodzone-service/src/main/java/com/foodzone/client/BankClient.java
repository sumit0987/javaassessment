package com.foodzone.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.foodzone.dto.FundsTransferDto;


@FeignClient(name="http://bank-service/bank")
public interface BankClient {
	
	@PostMapping("/payment")
	public int transferFunds(@RequestBody FundsTransferDto fundsTransferDto);
	
}
