/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.restservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTests {

	@Autowired
	private MockMvc mockMvc;

	/*
	Este método é um teste unitário em Java usando o framework Spring Boot. 
	Ele verifica se a API de saudação (/greeting) está funcionando corretamente quando não há parâmetros fornecidos. Aqui está uma explicação detalhada:

	@Test: Indica que este é um método de teste.
	public void noParamGreetingShouldReturnDefaultMessage() throws Exception: Define o método de teste que não aceita parâmetros e pode lançar uma exceção.
	this.mockMvc.perform(get("/greeting")): Simula uma requisição HTTP GET para o endpoint /greeting.
	andDo(print()): Imprime os detalhes da requisição e resposta no console para fins de depuração.
	andExpect(status().isOk()): Verifica se o status da resposta HTTP é 200 (OK).
	andExpect(jsonPath("$.content").value("Hello, World!")): Verifica se o campo content no JSON da resposta contém o valor "Hello, World!".
	*/
	@Test
	public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

		this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("Hello, World!"));
	}

	/*
	Este método é um teste unitário em Java usando o framework Spring Boot. 
	Ele verifica se a API de saudação (/greeting) retorna uma mensagem personalizada quando um parâmetro é fornecido. Aqui está uma explicação detalhada:

	@Test: Indica que este é um método de teste.
	public void paramGreetingShouldReturnTailoredMessage() throws Exception: Define o método de teste que não aceita parâmetros e pode lançar uma exceção.
	this.mockMvc.perform(get("/greeting").param("name", "Spring Community")): Simula uma requisição HTTP GET para o endpoint /greeting com um parâmetro de consulta name definido como "Spring Community".
	andDo(print()): Imprime os detalhes da requisição e resposta no console para fins de depuração.
	andExpect(status().isOk()): Verifica se o status da resposta HTTP é 200 (OK).
	andExpect(jsonPath("$.content").value("Hello, Spring Community!")): Verifica se o campo content no JSON da resposta contém o valor "Hello, Spring Community!".
	*/
	@Test
	public void paramGreetingShouldReturnTailoredMessage() throws Exception {

		this.mockMvc.perform(get("/greeting").param("name", "Spring Community"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
	}

}
