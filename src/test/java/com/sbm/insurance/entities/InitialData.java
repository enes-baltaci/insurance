package com.sbm.insurance.entities;

import com.sbm.insurance.services.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class InitialData {

    @Autowired
    private CarBrandsService carBrandsService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CarTypesService carTypesService;

    @Autowired
    private TravelTypesService travelTypesService;

    @Autowired
    private AddressService addressService;

    @Test
    void initialData() {

        ArrayList<CarBrands> carBrands = new ArrayList<>() {
            {
                add(CarBrands.builder().carBrand("Mercedes-Benz").carBrandMultiplier(3f).build());
                add(CarBrands.builder().carBrand("BMW").carBrandMultiplier(3f).build());
                add(CarBrands.builder().carBrand("Audi").carBrandMultiplier(3f).build());
                add(CarBrands.builder().carBrand("Volkswagen").carBrandMultiplier(2f).build());
                add(CarBrands.builder().carBrand("Nissan").carBrandMultiplier(2f).build());
                add(CarBrands.builder().carBrand("Renault").carBrandMultiplier(2f).build());
                add(CarBrands.builder().carBrand("Peugeot").carBrandMultiplier(1.5f).build());
                add(CarBrands.builder().carBrand("Skoda").carBrandMultiplier(1.5f).build());
                add(CarBrands.builder().carBrand("Opel").carBrandMultiplier(1.5f).build());
                add(CarBrands.builder().carBrand("Mini Cooper").carBrandMultiplier(1.25f).build());
                add(CarBrands.builder().carBrand("Hyundai").carBrandMultiplier(1.25f).build());
                add(CarBrands.builder().carBrand("Kia").carBrandMultiplier(1.25f).build());
            }
        };

        for (CarBrands brands : carBrands) {
            carBrandsService.save(brands);
        }

        ArrayList<Account> accounts = new ArrayList<>() {
            {
                add(Account.builder().identity(12345L).name("Enes").surname("Baltacı").email("enes@gmail.com").age(24).city("İstanbul").build());
                add(Account.builder().identity(12346L).name("Nazif").surname("İlbek").email("nazif@gmail.com").age(30).city("İstanbul").build());
                add(Account.builder().identity(12347L).name("İrem").surname("Er").email("irem@gmail.com").age(23).city("Muğla").build());
            }
        };

        for (Account account : accounts) {
            accountService.save(account);
        }

        ArrayList<CarTypes> carTypes = new ArrayList<>() {
            {
                add(CarTypes.builder().carType("Sedan").carTypeMultiplier(0.3f).build());
                add(CarTypes.builder().carType("SUV").carTypeMultiplier(0.15f).build());
                add(CarTypes.builder().carType("Hatchback").carTypeMultiplier(0.1f).build());
                add(CarTypes.builder().carType("MPV").carTypeMultiplier(0.12f).build());
                add(CarTypes.builder().carType("Crossover").carTypeMultiplier(0.27f).build());
                add(CarTypes.builder().carType("Coupe").carTypeMultiplier(0.17f).build());
                add(CarTypes.builder().carType("Convertible").carTypeMultiplier(0.25f).build());
            }
        };

        for (CarTypes types : carTypes) {
            carTypesService.save(types);
        }

        ArrayList<TravelTypes> travelTypes = new ArrayList<>() {
            {
                add(TravelTypes.builder().travelType("Flight").price(6500).distanceMultiplier(320).dayMultiplier(50).build());
                add(TravelTypes.builder().travelType("Bus").price(4250).distanceMultiplier(120).dayMultiplier(25).build());
                add(TravelTypes.builder().travelType("Train").price(3000).distanceMultiplier(200).dayMultiplier(35).build());
                add(TravelTypes.builder().travelType("Ship").price(5200).distanceMultiplier(525).dayMultiplier(70).build());
                add(TravelTypes.builder().travelType("Personal").price(7000).distanceMultiplier(340).dayMultiplier(60).build());
            }
        };

        for (TravelTypes types : travelTypes) {
            travelTypesService.save(types);
        }

        ArrayList<Address> addresses = new ArrayList<>() {
            {
                add(Address.builder().city("Adana").priceMultiplier(3f).build());
                add(Address.builder().city("Adıyaman").priceMultiplier(1f).build());
                add(Address.builder().city("Afyonkarahisar").priceMultiplier(1f).build());
                add(Address.builder().city("Ağrı").priceMultiplier(1f).build());
                add(Address.builder().city("Aksaray").priceMultiplier(1f).build());
                add(Address.builder().city("Amasya").priceMultiplier(1f).build());
                add(Address.builder().city("Ankara").priceMultiplier(4f).build());
                add(Address.builder().city("Antalya").priceMultiplier(3f).build());
                add(Address.builder().city("Ardahan").priceMultiplier(1f).build());
                add(Address.builder().city("Artvin").priceMultiplier(1f).build());
                add(Address.builder().city("Aydın").priceMultiplier(6f).build());
                add(Address.builder().city("Balıkesir").priceMultiplier(6f).build());
                add(Address.builder().city("Bartın").priceMultiplier(1f).build());
                add(Address.builder().city("Batman").priceMultiplier(1f).build());
                add(Address.builder().city("Bayburt").priceMultiplier(1f).build());
                add(Address.builder().city("Bilecik").priceMultiplier(1f).build());
                add(Address.builder().city("Bingöl").priceMultiplier(2f).build());
                add(Address.builder().city("Bitlis").priceMultiplier(1f).build());
                add(Address.builder().city("Bolu").priceMultiplier(2f).build());
                add(Address.builder().city("Burdur").priceMultiplier(2f).build());
                add(Address.builder().city("Bursa").priceMultiplier(6f).build());
                add(Address.builder().city("Çanakkale").priceMultiplier(1f).build());
                add(Address.builder().city("Çankırı").priceMultiplier(1f).build());
                add(Address.builder().city("Çorum").priceMultiplier(1f).build());
                add(Address.builder().city("Denizli").priceMultiplier(6f).build());
                add(Address.builder().city("Diyarbakır").priceMultiplier(3f).build());
                add(Address.builder().city("Düzce").priceMultiplier(1f).build());
                add(Address.builder().city("Edirne").priceMultiplier(1f).build());
                add(Address.builder().city("Elazığ").priceMultiplier(1f).build());
                add(Address.builder().city("Erzincan").priceMultiplier(2f).build());
                add(Address.builder().city("Erzurum").priceMultiplier(6f).build());
                add(Address.builder().city("Eskişehir").priceMultiplier(6f).build());
                add(Address.builder().city("Gaziantep").priceMultiplier(3f).build());
                add(Address.builder().city("Giresun").priceMultiplier(1f).build());
                add(Address.builder().city("Gümüşhane").priceMultiplier(1f).build());
                add(Address.builder().city("Hakkari").priceMultiplier(2f).build());
                add(Address.builder().city("Hatay").priceMultiplier(6f).build());
                add(Address.builder().city("Iğdır").priceMultiplier(1f).build());
                add(Address.builder().city("Isparta").priceMultiplier(1f).build());
                add(Address.builder().city("İstanbul").priceMultiplier(10f).build());
                add(Address.builder().city("İzmir").priceMultiplier(6f).build());
                add(Address.builder().city("Kahramanmaraş").priceMultiplier(6f).build());
                add(Address.builder().city("Karabük").priceMultiplier(1f).build());
                add(Address.builder().city("Karaman").priceMultiplier(1f).build());
                add(Address.builder().city("Kars").priceMultiplier(1f).build());
                add(Address.builder().city("Kastamonu").priceMultiplier(1f).build());
                add(Address.builder().city("Kayseri").priceMultiplier(6f).build());
                add(Address.builder().city("Kırıkkale").priceMultiplier(1f).build());
                add(Address.builder().city("Kırklareli").priceMultiplier(1f).build());
                add(Address.builder().city("Kırşehir").priceMultiplier(1f).build());
                add(Address.builder().city("Kilis").priceMultiplier(1f).build());
                add(Address.builder().city("Kocaeli").priceMultiplier(6f).build());
                add(Address.builder().city("Konya").priceMultiplier(3f).build());
                add(Address.builder().city("Kütahya").priceMultiplier(2f).build());
                add(Address.builder().city("Malatya").priceMultiplier(3f).build());
                add(Address.builder().city("Manisa").priceMultiplier(6f).build());
                add(Address.builder().city("Mardin").priceMultiplier(3f).build());
                add(Address.builder().city("Mersin").priceMultiplier(3f).build());
                add(Address.builder().city("Muğla").priceMultiplier(6f).build());
                add(Address.builder().city("Muş").priceMultiplier(1f).build());
                add(Address.builder().city("Nevşehir").priceMultiplier(1f).build());
                add(Address.builder().city("Niğde").priceMultiplier(1f).build());
                add(Address.builder().city("Ordu").priceMultiplier(3f).build());
                add(Address.builder().city("Osmaniye").priceMultiplier(2f).build());
                add(Address.builder().city("Rize").priceMultiplier(1f).build());
                add(Address.builder().city("Sakarya").priceMultiplier(6f).build());
                add(Address.builder().city("Samsun").priceMultiplier(3f).build());
                add(Address.builder().city("Siirt").priceMultiplier(1f).build());
                add(Address.builder().city("Sinop").priceMultiplier(1f).build());
                add(Address.builder().city("Sivas").priceMultiplier(1f).build());
                add(Address.builder().city("Şanlıurfa").priceMultiplier(3f).build());
                add(Address.builder().city("Şırnak").priceMultiplier(1f).build());
                add(Address.builder().city("Tekirdağ").priceMultiplier(3f).build());
                add(Address.builder().city("Tokat").priceMultiplier(6f).build());
                add(Address.builder().city("Trabzon").priceMultiplier(3f).build());
                add(Address.builder().city("Tunceli").priceMultiplier(1f).build());
                add(Address.builder().city("Uşak").priceMultiplier(1f).build());
                add(Address.builder().city("Van").priceMultiplier(3f).build());
                add(Address.builder().city("Yalova").priceMultiplier(1f).build());
                add(Address.builder().city("Yozgat").priceMultiplier(1f).build());
                add(Address.builder().city("Zonguldak").priceMultiplier(1f).build());
            }
        };

        for (Address address : addresses) {
            addressService.save(address);
        }
    }

}