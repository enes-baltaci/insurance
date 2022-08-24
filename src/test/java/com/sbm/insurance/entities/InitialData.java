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
    private CitiesService citiesService;

    @Autowired
    private DaskDamageStatusService daskDamageStatusService;

    @Autowired
    private DaskBuildingStyleService daskBuildingStyleService;

    @Test
    void initialData() {

        ArrayList<DaskBuildingStyle> daskBuildingStyles = new ArrayList<>() {
            {
                add(DaskBuildingStyle.builder().buildingStyle("Masonry").priceMultiplier(1.7f).build());
                add(DaskBuildingStyle.builder().buildingStyle("Steel, Reinforced Concrete Carcass").priceMultiplier(1.2f).build());
                add(DaskBuildingStyle.builder().buildingStyle("Other").priceMultiplier(2.5f).build());
            }
        };

        for (DaskBuildingStyle buildingStyle : daskBuildingStyles) {
            daskBuildingStyleService.save(buildingStyle);
        }

        ArrayList<DaskDamageStatus> daskDamageStatuses = new ArrayList<>() {
            {
                add(DaskDamageStatus.builder().damageStatus("Undamaged").priceMultiplier(1.1f).build());
                add(DaskDamageStatus.builder().damageStatus("Little Damaged").priceMultiplier(1.4f).build());
                add(DaskDamageStatus.builder().damageStatus("Medium Damaged").priceMultiplier(1.7f).build());
                add(DaskDamageStatus.builder().damageStatus("Heavy Damaged").priceMultiplier(2.5f).build());
                add(DaskDamageStatus.builder().damageStatus("Demolish Immediately").priceMultiplier(5f).build());
            }
        };

        for (DaskDamageStatus daskDamageStatus : daskDamageStatuses) {
            daskDamageStatusService.save(daskDamageStatus);
        }

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

        ArrayList<Cities> cities = new ArrayList<>() {
            {
                add(Cities.builder().cityName("Adana").priceMultiplier(3f).build());
                add(Cities.builder().cityName("Adıyaman").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Afyonkarahisar").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Ağrı").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Aksaray").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Amasya").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Ankara").priceMultiplier(4f).build());
                add(Cities.builder().cityName("Antalya").priceMultiplier(3f).build());
                add(Cities.builder().cityName("Ardahan").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Artvin").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Aydın").priceMultiplier(6f).build());
                add(Cities.builder().cityName("Balıkesir").priceMultiplier(6f).build());
                add(Cities.builder().cityName("Bartın").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Batman").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Bayburt").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Bilecik").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Bingöl").priceMultiplier(2f).build());
                add(Cities.builder().cityName("Bitlis").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Bolu").priceMultiplier(2f).build());
                add(Cities.builder().cityName("Burdur").priceMultiplier(2f).build());
                add(Cities.builder().cityName("Bursa").priceMultiplier(6f).build());
                add(Cities.builder().cityName("Çanakkale").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Çankırı").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Çorum").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Denizli").priceMultiplier(6f).build());
                add(Cities.builder().cityName("Diyarbakır").priceMultiplier(3f).build());
                add(Cities.builder().cityName("Düzce").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Edirne").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Elazığ").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Erzincan").priceMultiplier(2f).build());
                add(Cities.builder().cityName("Erzurum").priceMultiplier(6f).build());
                add(Cities.builder().cityName("Eskişehir").priceMultiplier(6f).build());
                add(Cities.builder().cityName("Gaziantep").priceMultiplier(3f).build());
                add(Cities.builder().cityName("Giresun").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Gümüşhane").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Hakkari").priceMultiplier(2f).build());
                add(Cities.builder().cityName("Hatay").priceMultiplier(6f).build());
                add(Cities.builder().cityName("Iğdır").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Isparta").priceMultiplier(1f).build());
                add(Cities.builder().cityName("İstanbul").priceMultiplier(10f).build());
                add(Cities.builder().cityName("İzmir").priceMultiplier(6f).build());
                add(Cities.builder().cityName("Kahramanmaraş").priceMultiplier(6f).build());
                add(Cities.builder().cityName("Karabük").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Karaman").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Kars").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Kastamonu").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Kayseri").priceMultiplier(6f).build());
                add(Cities.builder().cityName("Kırıkkale").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Kırklareli").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Kırşehir").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Kilis").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Kocaeli").priceMultiplier(6f).build());
                add(Cities.builder().cityName("Konya").priceMultiplier(3f).build());
                add(Cities.builder().cityName("Kütahya").priceMultiplier(2f).build());
                add(Cities.builder().cityName("Malatya").priceMultiplier(3f).build());
                add(Cities.builder().cityName("Manisa").priceMultiplier(6f).build());
                add(Cities.builder().cityName("Mardin").priceMultiplier(3f).build());
                add(Cities.builder().cityName("Mersin").priceMultiplier(3f).build());
                add(Cities.builder().cityName("Muğla").priceMultiplier(6f).build());
                add(Cities.builder().cityName("Muş").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Nevşehir").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Niğde").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Ordu").priceMultiplier(3f).build());
                add(Cities.builder().cityName("Osmaniye").priceMultiplier(2f).build());
                add(Cities.builder().cityName("Rize").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Sakarya").priceMultiplier(6f).build());
                add(Cities.builder().cityName("Samsun").priceMultiplier(3f).build());
                add(Cities.builder().cityName("Siirt").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Sinop").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Sivas").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Şanlıurfa").priceMultiplier(3f).build());
                add(Cities.builder().cityName("Şırnak").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Tekirdağ").priceMultiplier(3f).build());
                add(Cities.builder().cityName("Tokat").priceMultiplier(6f).build());
                add(Cities.builder().cityName("Trabzon").priceMultiplier(3f).build());
                add(Cities.builder().cityName("Tunceli").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Uşak").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Van").priceMultiplier(3f).build());
                add(Cities.builder().cityName("Yalova").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Yozgat").priceMultiplier(1f).build());
                add(Cities.builder().cityName("Zonguldak").priceMultiplier(1f).build());
            }
        };

        for (Cities city : cities) {
            citiesService.save(city);
        }

        ArrayList<Account> accounts = new ArrayList<>() {
            {
                add(Account.builder()
                        .identity(12345L)
                        .name("Enes")
                        .surname("Baltacı")
                        .email("enes@gmail.com")
                        .age(24)
                        .city(citiesService.getCityById(40L))
                        .build());
                add(Account.builder()
                        .identity(12346L)
                        .name("Nazif")
                        .surname("İlbek")
                        .email("nazif@gmail.com")
                        .age(30)
                        .city(citiesService.getCityById(7L))
                        .build());
                add(Account.builder()
                        .identity(12347L)
                        .name("İrem")
                        .surname("Er")
                        .email("irem@gmail.com")
                        .age(23)
                        .city(citiesService.getCityById(41L))
                        .build());
            }
        };

        for (Account account : accounts) {
            accountService.save(account);
        }
    }
}