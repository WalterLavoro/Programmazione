package com.spring.ProgettoDemo.service;

import java.util.List;

import com.spring.ProgettoDemo.dto.DtoNegozio;
import com.spring.ProgettoDemo.dto.DtoRegistraNegozio;

public interface ServiceNegozio {
		public Boolean createNegozio(DtoRegistraNegozio n);
		public List<DtoNegozio> allNegozi();
		public Boolean deleteAll();
		
}
