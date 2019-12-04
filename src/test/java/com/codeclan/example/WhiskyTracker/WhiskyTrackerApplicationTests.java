package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findWhiskysThatHaveParticularYear(){
		List<Whisky> foundWhiskys = whiskyRepository.findWhiskysThatHaveParticularYear(1991);
		assertEquals(1, foundWhiskys.size());
		assertEquals("The Rosebank 12 - Flora and Fona", foundWhiskys.get(0).getName());
	}

	@Test
	public void findDistilleriesWithParticularRegion(){
		List<Distillery> foundDistilleries = distilleryRepository.findDistilleriesWithParticularRegion("Highland");
		assertEquals(1, foundDistilleries.size());
		assertEquals("Glendronach", foundDistilleries.get(0).getName());
	}

	@Test
	public void canFindWhiskysThatHaveSpecificAgeAndParticularDistillery(){

		List<Whisky> foundWhiskys = whiskyRepository.findWhiskysByAgeAndDistilleryId(15, 1L);
		assertEquals(1, foundWhiskys.size());
	}

}