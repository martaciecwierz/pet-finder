package com.example.petfinder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.example.petfinder.dto.animal.AnimalDto;
import com.example.petfinder.model.animal.Animal;
import com.example.petfinder.repository.AnimalRepository;
import com.example.petfinder.service.AnimalService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class AnimalServiceTest {

    @Mock
    private AnimalRepository  animalRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private AnimalService animalService;
    private Animal animal;
    private AnimalDto animalDto;

    @Before
    public void setUp(){

        animal = Animal.builder()
                .id(1L)
                .name("test_name")
                .description("test_description")
                .build();

        animalDto = AnimalDto.builder()
                .id(1L)
                .name("test_name")
                .description("test_description")
                .build();

        when(animalRepository.findById(1L)).thenReturn(Optional.of(animal));
        when(modelMapper.map(animal, AnimalDto.class)).thenReturn(animalDto);
    }

    @Test
    public void getAnimalByIdTest(){
        AnimalDto animalDto = animalService.findAnimalById(1L);

        assertEquals("test_name", animalDto.getName());
        assertEquals("test_description", animalDto.getDescription());
    }

}
