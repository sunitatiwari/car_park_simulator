package com.fdm.carParkSimulator;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.fdm.controller.CarParkController;
import com.fdm.customException.CarParkSimulatorException;
import com.fdm.model.Car;
import com.fdm.model.CarSpace;
import com.fdm.validator.CarParkValidator;

public class CarParkControllerTest {

	private CarParkController controller;
	private CarParkValidator validator;
	private Car car;
	private CarSpace carSpace;
	
	private String invalidCommandErrorMessage = "ERROR!\nValid inputs include \nEnter car \nEnter truck "
			+ "\nExit car <Number of hours>\nExit truck <Number of hours> \nReport \nQuit";

	@Before
	public void setUpTest() {
		validator = mock(CarParkValidator.class);
		controller = new CarParkController(validator);
	}

	@Test
	public void when_user_inputs_value_for_total_parking_space_validation_of_the_input_occurs()
			throws CarParkSimulatorException {
		int carSpace = 20;
		controller.isTotalCarSpaceValid(carSpace);
		verify(validator).validateTotalParkingSpace(carSpace);
	}

	@Test(expected = CarParkSimulatorException.class)
	public void when_user_inputs_a_number_too_large_for_an_interger_for_total_parking_space_exception_is_thrown()
			throws CarParkSimulatorException {
		int carSpace = 2147483647;
		doThrow(new CarParkSimulatorException("Error\nInteger number too large")).when(validator)
				.validateTotalParkingSpace(carSpace);
		controller.isTotalCarSpaceValid(carSpace);
		verify(validator).validateTotalParkingSpace(carSpace);
	}

	@Test
	public void when_user_inputs_a_string_enter_car_validation_of_the_input_occurs() throws CarParkSimulatorException {
		String commandString = "Enter car";
		controller.isCommandStringValid(commandString);
		verify(validator).validateCommandString(commandString);
	}

	@Test(expected = CarParkSimulatorException.class)
	public void when_user_inputs_exit_truck_exception_is_thrown() throws CarParkSimulatorException {
		String commandString = "Exit truck";
		doThrow(new CarParkSimulatorException(invalidCommandErrorMessage)).when(validator)
				.validateCommandString(commandString);
		controller.isCommandStringValid(commandString);
		verify(validator).validateCommandString(commandString);
	}
}
