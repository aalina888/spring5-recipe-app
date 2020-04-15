package com.aalina.spring5recipeapp.controllers;

import com.aalina.spring5recipeapp.services.ImageService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ImageControllerTest {
    @Mock
    ImageService imageService;

    ImageController controller;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new ImageController(imageService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void handleImagePostTest() throws Exception {
        MockMultipartFile multipartFile = new MockMultipartFile("file", "testing.txt",
                "text/plain", "Spring aalina888".getBytes());

        this.mockMvc.perform(multipart("/recipe/image").file(multipartFile))
                .andExpect(status().isFound())
                .andExpect(header().string("Location", "/"));
    }
}