package com.foodzone.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodzone.entity.FoodOutlet;
import com.foodzone.repository.FoodOutletRepository;

@Service
public class OutletServiceImpl implements OutletService {

	@Autowired
	FoodOutletRepository foodOutletRepository;
	
	@Override
	public List<FoodOutlet> searchFoodOutlets(String outletName) {
		// TODO Auto-generated method stub
		List<FoodOutlet> outletList = foodOutletRepository.findByOutletNameContaining(outletName);
		if(Objects.isNull(outletList)||outletList.size()==0) {
			throw new RuntimeException("Record Not Found");
		}
		return outletList;
	}

}
