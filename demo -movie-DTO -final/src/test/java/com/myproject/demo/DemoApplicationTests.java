package com.myproject.demo;

import com.myproject.demo.dao.MovieRepository;
import com.myproject.demo.dto.MovieDto;
import com.myproject.demo.entity.Movie;
import com.myproject.demo.service.MovieService;
import com.myproject.demo.service.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.ExpectedCount.times;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {


	@Autowired
	private MovieService movieService;

	@MockBean
	private MovieRepository movieRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void toTestFindAll(){

		when(movieRepository.findAll()).thenReturn(Stream.of(new Movie(1,"movie1","telugu")).collect(toList()));
		assertEquals(1,movieService.findAll().size());
	}
	@Test
	void toTestSave()
	{
		Movie theMovie = new Movie(101,"MovieDemo","Tamil");
		/*when(movieRepository.save(theMovie)).thenReturn(theMovie);
		assertEquals(theMovie,movieService.save(theMovie));*/
		movieService.save(theMovie);
		verify(movieRepository).save(theMovie);

	}


	@Test
	void toTestDeleteById()
	{
		 int id =101;

		movieService.deleteById(id) ;
		verify(movieRepository).deleteById(id);
	}




}
