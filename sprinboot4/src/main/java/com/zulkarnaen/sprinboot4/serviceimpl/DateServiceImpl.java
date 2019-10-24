package com.zulkarnaen.sprinboot4.serviceimpl;

import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;

import com.zulkarnaen.sprinboot4.service.DateService;

@Service("dateService")
public class DateServiceImpl implements DateService {

	public LocalDate getNextAssessmentDate() {
		return new LocalDate(2015, 10, 10);
	}

}
