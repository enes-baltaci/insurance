package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Account;
import com.sbm.insurance.entities.City;
import com.sbm.insurance.repositories.AccountRepository;
import com.sbm.insurance.repositories.CitiesRepository;
import com.sbm.insurance.services.AccountService;
import com.sbm.insurance.services.CitiesService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ConcurrentModel;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {AccountController.class, AccountService.class, CitiesService.class})
@ExtendWith(SpringExtension.class)
class AccountControllerTest {
    @Autowired
    private AccountController accountController;

    @MockBean
    private AccountRepository accountRepository;

    @MockBean
    private CitiesRepository citiesRepository;

    @Test
    void testAccountList() {
        AccountRepository accountRepository = mock(AccountRepository.class);
        when(accountRepository.findAll()).thenReturn(new ArrayList<>());
        AccountService accountService = new AccountService(accountRepository);
        AccountController accountController = new AccountController(accountService,
                new CitiesService(mock(CitiesRepository.class)));
        assertEquals("account_list", accountController.accountList(new ConcurrentModel()));
        verify(accountRepository).findAll();
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testAccountList2() {
        AccountController accountController = new AccountController(null,
                new CitiesService(mock(CitiesRepository.class)));
        accountController.accountList(new ConcurrentModel());
    }

    @Test
    void testAccountList3() {
        AccountService accountService = mock(AccountService.class);
        when(accountService.getAll()).thenReturn(new ArrayList<>());
        AccountController accountController = new AccountController(accountService,
                new CitiesService(mock(CitiesRepository.class)));
        assertEquals("account_list", accountController.accountList(new ConcurrentModel()));
        verify(accountService).getAll();
    }

    @Test
    void testCreateAccount() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/account_registration");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(accountController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testDeleteAccount() throws Exception {
        doNothing().when(accountRepository).deleteById(any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/account/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(accountController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/account_list"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/account_list"));
    }

    @Test
    void testDeleteAccount2() throws Exception {
        doNothing().when(accountRepository).deleteById(any());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/account/delete/{id}", 123L);
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(accountController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/account_list"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/account_list"));
    }

    @Test
    void testEditAccount() throws Exception {
        City city = new City();
        city.setAccounts(new ArrayList<>());
        city.setAddresses(new ArrayList<>());
        city.setCityName("Oxford");
        city.setId(123L);
        city.setPriceMultiplier(10.0f);

        Account account = new Account();
        account.setAge(1);
        account.setCars(new ArrayList<>());
        account.setCity(city);
        account.setDasks(new ArrayList<>());
        account.setEmail("jane.doe@example.org");
        account.setId(123L);
        account.setIdentity(1L);
        account.setName("Name");
        account.setSurname("Doe");
        account.setTravels(new ArrayList<>());
        Optional<Account> ofResult = Optional.of(account);

        City city1 = new City();
        city1.setAccounts(new ArrayList<>());
        city1.setAddresses(new ArrayList<>());
        city1.setCityName("Oxford");
        city1.setId(123L);
        city1.setPriceMultiplier(10.0f);

        Account account1 = new Account();
        account1.setAge(1);
        account1.setCars(new ArrayList<>());
        account1.setCity(city1);
        account1.setDasks(new ArrayList<>());
        account1.setEmail("jane.doe@example.org");
        account1.setId(123L);
        account1.setIdentity(1L);
        account1.setName("Name");
        account1.setSurname("Doe");
        account1.setTravels(new ArrayList<>());
        when(accountRepository.save(any())).thenReturn(account1);
        when(accountRepository.findById(any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/account_edit/{id}", 123L);
        MockMvcBuilders.standaloneSetup(accountController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("account"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/info/update"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/info/update"));
    }

    @Test
    void testEditAccount2() throws Exception {
        City city = new City();
        city.setAccounts(new ArrayList<>());
        city.setAddresses(new ArrayList<>());
        city.setCityName("Oxford");
        city.setId(123L);
        city.setPriceMultiplier(10.0f);

        Account account = new Account();
        account.setAge(1);
        account.setCars(new ArrayList<>());
        account.setCity(city);
        account.setDasks(new ArrayList<>());
        account.setEmail("jane.doe@example.org");
        account.setId(123L);
        account.setIdentity(1L);
        account.setName("Name");
        account.setSurname("Doe");
        account.setTravels(new ArrayList<>());
        when(accountRepository.save(any())).thenReturn(account);
        when(accountRepository.findById(any())).thenReturn(Optional.empty());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/account_edit/{id}", 123L);
        MockMvcBuilders.standaloneSetup(accountController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("account"))
                .andExpect(MockMvcResultMatchers.view().name("id_error"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("id_error"));
    }

    @Test
    void testEmailExist() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/emailExist");
        MockMvcBuilders.standaloneSetup(accountController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("flag"))
                .andExpect(MockMvcResultMatchers.view().name("account_info"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("account_info"));
    }

    @Test
    void testEmailExist2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/emailExist");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(accountController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("flag"))
                .andExpect(MockMvcResultMatchers.view().name("account_info"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("account_info"));
    }

    @Test
    void testEmailExistUpdated() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/emailExist/update/{id}", "42");
        MockMvcBuilders.standaloneSetup(accountController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(3))
                .andExpect(MockMvcResultMatchers.model().attributeExists("flag", "id", "updated"))
                .andExpect(MockMvcResultMatchers.view().name("account_info"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("account_info"));
    }

    @Test
    void testEmailExistUpdated2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/emailExist/update/{id}", "42");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(accountController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(3))
                .andExpect(MockMvcResultMatchers.model().attributeExists("flag", "id", "updated"))
                .andExpect(MockMvcResultMatchers.view().name("account_info"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("account_info"));
    }

    @Test
    void testRegistration() throws Exception {
        when(citiesRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/create_account");
        MockMvcBuilders.standaloneSetup(accountController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(4))
                .andExpect(MockMvcResultMatchers.model().attributeExists("account", "action", "cities", "processName"))
                .andExpect(MockMvcResultMatchers.view().name("account"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("account"));
    }

    @Test
    void testRegistration2() throws Exception {
        when(citiesRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/create_account");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(accountController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(4))
                .andExpect(MockMvcResultMatchers.model().attributeExists("account", "action", "cities", "processName"))
                .andExpect(MockMvcResultMatchers.view().name("account"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("account"));
    }

    @Test
    void testSendAccount() throws Exception {
        City city = new City();
        city.setAccounts(new ArrayList<>());
        city.setAddresses(new ArrayList<>());
        city.setCityName("Oxford");
        city.setId(123L);
        city.setPriceMultiplier(10.0f);

        Account account = new Account();
        account.setAge(1);
        account.setCars(new ArrayList<>());
        account.setCity(city);
        account.setDasks(new ArrayList<>());
        account.setEmail("jane.doe@example.org");
        account.setId(124L);
        account.setIdentity(1L);
        account.setName("Name");
        account.setSurname("Doe");
        account.setTravels(new ArrayList<>());
        Optional<Account> ofResult = Optional.of(account);

        when(accountRepository.findById(any())).thenReturn(ofResult);
        when(citiesRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/account_edit/{id}", 123L);
        MockMvcBuilders.standaloneSetup(accountController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(4))
                .andExpect(MockMvcResultMatchers.model().attributeExists("account", "action", "cities", "processName"))
                .andExpect(MockMvcResultMatchers.view().name("account"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("account"));
    }

    @Test
    void testSendAccount2() throws Exception {
        when(accountRepository.findById(any())).thenReturn(Optional.empty());
        when(citiesRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/account_edit/{id}", 123L);
        MockMvcBuilders.standaloneSetup(accountController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("id_error"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("id_error"));
    }

    @Test
    void testSubmitInfoCreate() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/info");
        MockMvcBuilders.standaloneSetup(accountController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("account_info"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("account_info"));
    }

    @Test
    void testSubmitInfoCreate2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/info");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(accountController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("account_info"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("account_info"));
    }

    @Test
    void testSubmitInfoUpdate() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/info/update");
        MockMvcBuilders.standaloneSetup(accountController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("updated"))
                .andExpect(MockMvcResultMatchers.view().name("account_info"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("account_info"));
    }

    @Test
    void testSubmitInfoUpdate2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/info/update");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(accountController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("updated"))
                .andExpect(MockMvcResultMatchers.view().name("account_info"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("account_info"));
    }
}

