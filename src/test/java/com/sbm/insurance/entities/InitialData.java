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

    @Autowired
    private DaskAreaService daskAreaService;

    @Autowired
    private DaskFloorNumberService daskFloorNumberService;

    @Autowired
    private DaskBuildYearService daskBuildYearService;

    @Autowired
    private CarModelAgeService carModelAgeService;

    @Test
    void initialData() {

        ArrayList<CarModelAge> carModelAges = new ArrayList<>() {
            {
                add(CarModelAge.builder().modelAge(10).modelAgeMultiplier(1.25f).build());
                add(CarModelAge.builder().modelAge(5).modelAgeMultiplier(1.5f).build());
                add(CarModelAge.builder().modelAge(3).modelAgeMultiplier(1.75f).build());
                add(CarModelAge.builder().modelAge(0).modelAgeMultiplier(2f).build());
            }
        };

        for (CarModelAge carModelAge : carModelAges) {
            carModelAgeService.save(carModelAge);
        }

        ArrayList<DaskBuildYear> daskBuildYears = new ArrayList<>() {
            {
                add(DaskBuildYear.builder().buildYear(10).buildYearMultiplier(5f).build());
                add(DaskBuildYear.builder().buildYear(5).buildYearMultiplier(3.75f).build());
                add(DaskBuildYear.builder().buildYear(2).buildYearMultiplier(2.5f).build());
                add(DaskBuildYear.builder().buildYear(0).buildYearMultiplier(1.25f).build());
            }
        };

        for (DaskBuildYear daskBuildYear : daskBuildYears) {
            daskBuildYearService.save(daskBuildYear);
        }

        ArrayList<DaskFloorNumber> daskFloorNumbers = new ArrayList<>() {
            {
                add(DaskFloorNumber.builder().floorNumber(50).floorNumberMultiplier(1.6f).build());
                add(DaskFloorNumber.builder().floorNumber(40).floorNumberMultiplier(1.5f).build());
                add(DaskFloorNumber.builder().floorNumber(30).floorNumberMultiplier(1.4f).build());
                add(DaskFloorNumber.builder().floorNumber(20).floorNumberMultiplier(1.3f).build());
                add(DaskFloorNumber.builder().floorNumber(10).floorNumberMultiplier(1.2f).build());
                add(DaskFloorNumber.builder().floorNumber(0).floorNumberMultiplier(1.1f).build());
            }
        };

        for (DaskFloorNumber daskFloorNumber : daskFloorNumbers) {
            daskFloorNumberService.save(daskFloorNumber);
        }

        ArrayList<DaskArea> daskAreas = new ArrayList<>() {
            {
                add(DaskArea.builder().area(250).areaPriceMultiplier(2f).build());
                add(DaskArea.builder().area(200).areaPriceMultiplier(1.8f).build());
                add(DaskArea.builder().area(150).areaPriceMultiplier(1.6f).build());
                add(DaskArea.builder().area(100).areaPriceMultiplier(1.4f).build());
                add(DaskArea.builder().area(50).areaPriceMultiplier(1.2f).build());
                add(DaskArea.builder().area(0).areaPriceMultiplier(1.1f).build());
            }
        };

        for (DaskArea daskArea : daskAreas) {
            daskAreaService.save(daskArea);
        }

        ArrayList<DaskBuildingStyle> daskBuildingStyles = new ArrayList<>() {
            {
                add(DaskBuildingStyle.builder().buildingStyle("Masonry").priceMultiplier(1.5f).build());
                add(DaskBuildingStyle.builder().buildingStyle("Steel, Reinforced Concrete Carcass").priceMultiplier(1.2f).build());
                add(DaskBuildingStyle.builder().buildingStyle("Other").priceMultiplier(1.8f).build());
            }
        };

        for (DaskBuildingStyle buildingStyle : daskBuildingStyles) {
            daskBuildingStyleService.save(buildingStyle);
        }

        ArrayList<DaskDamageStatus> daskDamageStatuses = new ArrayList<>() {
            {
                add(DaskDamageStatus.builder().damageStatus("Undamaged").priceMultiplier(1.1f).build());
                add(DaskDamageStatus.builder().damageStatus("Little Damaged").priceMultiplier(1.2f).build());
                add(DaskDamageStatus.builder().damageStatus("Medium Damaged").priceMultiplier(1.3f).build());
                add(DaskDamageStatus.builder().damageStatus("Heavy Damaged").priceMultiplier(1.4f).build());
                add(DaskDamageStatus.builder().damageStatus("Demolish Immediately").priceMultiplier(1.5f).build());
            }
        };

        for (DaskDamageStatus daskDamageStatus : daskDamageStatuses) {
            daskDamageStatusService.save(daskDamageStatus);
        }

        ArrayList<CarBrand> carBrands = new ArrayList<>() {
            {
                add(CarBrand.builder().carBrand("Mercedes-Benz").carBrandMultiplier(3f).build());
                add(CarBrand.builder().carBrand("BMW").carBrandMultiplier(3f).build());
                add(CarBrand.builder().carBrand("Audi").carBrandMultiplier(3f).build());
                add(CarBrand.builder().carBrand("Volkswagen").carBrandMultiplier(2f).build());
                add(CarBrand.builder().carBrand("Nissan").carBrandMultiplier(2f).build());
                add(CarBrand.builder().carBrand("Renault").carBrandMultiplier(2f).build());
                add(CarBrand.builder().carBrand("Peugeot").carBrandMultiplier(1.5f).build());
                add(CarBrand.builder().carBrand("Skoda").carBrandMultiplier(1.5f).build());
                add(CarBrand.builder().carBrand("Opel").carBrandMultiplier(1.5f).build());
                add(CarBrand.builder().carBrand("Mini Cooper").carBrandMultiplier(1.25f).build());
                add(CarBrand.builder().carBrand("Hyundai").carBrandMultiplier(1.25f).build());
                add(CarBrand.builder().carBrand("Kia").carBrandMultiplier(1.25f).build());
            }
        };

        for (CarBrand brands : carBrands) {
            carBrandsService.save(brands);
        }

        ArrayList<CarModel> carTypes = new ArrayList<>() {
            {
                add(CarModel.builder().carType("Sedan").carTypeMultiplier(0.3f).build());
                add(CarModel.builder().carType("SUV").carTypeMultiplier(0.15f).build());
                add(CarModel.builder().carType("Hatchback").carTypeMultiplier(0.1f).build());
                add(CarModel.builder().carType("MPV").carTypeMultiplier(0.12f).build());
                add(CarModel.builder().carType("Crossover").carTypeMultiplier(0.27f).build());
                add(CarModel.builder().carType("Coupe").carTypeMultiplier(0.17f).build());
                add(CarModel.builder().carType("Convertible").carTypeMultiplier(0.25f).build());
            }
        };

        for (CarModel types : carTypes) {
            carTypesService.save(types);
        }

        ArrayList<TravelType> travelTypes = new ArrayList<>() {
            {
                add(TravelType.builder().travelType("Flight").price(6500).distanceMultiplier(320).dayMultiplier(50).build());
                add(TravelType.builder().travelType("Bus").price(4250).distanceMultiplier(120).dayMultiplier(25).build());
                add(TravelType.builder().travelType("Train").price(3000).distanceMultiplier(200).dayMultiplier(35).build());
                add(TravelType.builder().travelType("Ship").price(5200).distanceMultiplier(525).dayMultiplier(70).build());
                add(TravelType.builder().travelType("Personal").price(7000).distanceMultiplier(340).dayMultiplier(60).build());
            }
        };

        for (TravelType types : travelTypes) {
            travelTypesService.save(types);
        }

        ArrayList<City> cities = new ArrayList<>() {
            {
                add(City.builder().cityName("Adana").priceMultiplier(3f).build());
                add(City.builder().cityName("Ad??yaman").priceMultiplier(1f).build());
                add(City.builder().cityName("Afyonkarahisar").priceMultiplier(1f).build());
                add(City.builder().cityName("A??r??").priceMultiplier(1f).build());
                add(City.builder().cityName("Aksaray").priceMultiplier(1f).build());
                add(City.builder().cityName("Amasya").priceMultiplier(1f).build());
                add(City.builder().cityName("Ankara").priceMultiplier(4f).build());
                add(City.builder().cityName("Antalya").priceMultiplier(3f).build());
                add(City.builder().cityName("Ardahan").priceMultiplier(1f).build());
                add(City.builder().cityName("Artvin").priceMultiplier(1f).build());
                add(City.builder().cityName("Ayd??n").priceMultiplier(6f).build());
                add(City.builder().cityName("Bal??kesir").priceMultiplier(6f).build());
                add(City.builder().cityName("Bart??n").priceMultiplier(1f).build());
                add(City.builder().cityName("Batman").priceMultiplier(1f).build());
                add(City.builder().cityName("Bayburt").priceMultiplier(1f).build());
                add(City.builder().cityName("Bilecik").priceMultiplier(1f).build());
                add(City.builder().cityName("Bing??l").priceMultiplier(2f).build());
                add(City.builder().cityName("Bitlis").priceMultiplier(1f).build());
                add(City.builder().cityName("Bolu").priceMultiplier(2f).build());
                add(City.builder().cityName("Burdur").priceMultiplier(2f).build());
                add(City.builder().cityName("Bursa").priceMultiplier(6f).build());
                add(City.builder().cityName("??anakkale").priceMultiplier(1f).build());
                add(City.builder().cityName("??ank??r??").priceMultiplier(1f).build());
                add(City.builder().cityName("??orum").priceMultiplier(1f).build());
                add(City.builder().cityName("Denizli").priceMultiplier(6f).build());
                add(City.builder().cityName("Diyarbak??r").priceMultiplier(3f).build());
                add(City.builder().cityName("D??zce").priceMultiplier(1f).build());
                add(City.builder().cityName("Edirne").priceMultiplier(1f).build());
                add(City.builder().cityName("Elaz????").priceMultiplier(1f).build());
                add(City.builder().cityName("Erzincan").priceMultiplier(2f).build());
                add(City.builder().cityName("Erzurum").priceMultiplier(6f).build());
                add(City.builder().cityName("Eski??ehir").priceMultiplier(6f).build());
                add(City.builder().cityName("Gaziantep").priceMultiplier(3f).build());
                add(City.builder().cityName("Giresun").priceMultiplier(1f).build());
                add(City.builder().cityName("G??m????hane").priceMultiplier(1f).build());
                add(City.builder().cityName("Hakkari").priceMultiplier(2f).build());
                add(City.builder().cityName("Hatay").priceMultiplier(6f).build());
                add(City.builder().cityName("I??d??r").priceMultiplier(1f).build());
                add(City.builder().cityName("Isparta").priceMultiplier(1f).build());
                add(City.builder().cityName("??stanbul").priceMultiplier(10f).build());
                add(City.builder().cityName("??zmir").priceMultiplier(6f).build());
                add(City.builder().cityName("Kahramanmara??").priceMultiplier(6f).build());
                add(City.builder().cityName("Karab??k").priceMultiplier(1f).build());
                add(City.builder().cityName("Karaman").priceMultiplier(1f).build());
                add(City.builder().cityName("Kars").priceMultiplier(1f).build());
                add(City.builder().cityName("Kastamonu").priceMultiplier(1f).build());
                add(City.builder().cityName("Kayseri").priceMultiplier(6f).build());
                add(City.builder().cityName("K??r??kkale").priceMultiplier(1f).build());
                add(City.builder().cityName("K??rklareli").priceMultiplier(1f).build());
                add(City.builder().cityName("K??r??ehir").priceMultiplier(1f).build());
                add(City.builder().cityName("Kilis").priceMultiplier(1f).build());
                add(City.builder().cityName("Kocaeli").priceMultiplier(6f).build());
                add(City.builder().cityName("Konya").priceMultiplier(3f).build());
                add(City.builder().cityName("K??tahya").priceMultiplier(2f).build());
                add(City.builder().cityName("Malatya").priceMultiplier(3f).build());
                add(City.builder().cityName("Manisa").priceMultiplier(6f).build());
                add(City.builder().cityName("Mardin").priceMultiplier(3f).build());
                add(City.builder().cityName("Mersin").priceMultiplier(3f).build());
                add(City.builder().cityName("Mu??la").priceMultiplier(6f).build());
                add(City.builder().cityName("Mu??").priceMultiplier(1f).build());
                add(City.builder().cityName("Nev??ehir").priceMultiplier(1f).build());
                add(City.builder().cityName("Ni??de").priceMultiplier(1f).build());
                add(City.builder().cityName("Ordu").priceMultiplier(3f).build());
                add(City.builder().cityName("Osmaniye").priceMultiplier(2f).build());
                add(City.builder().cityName("Rize").priceMultiplier(1f).build());
                add(City.builder().cityName("Sakarya").priceMultiplier(6f).build());
                add(City.builder().cityName("Samsun").priceMultiplier(3f).build());
                add(City.builder().cityName("Siirt").priceMultiplier(1f).build());
                add(City.builder().cityName("Sinop").priceMultiplier(1f).build());
                add(City.builder().cityName("Sivas").priceMultiplier(1f).build());
                add(City.builder().cityName("??anl??urfa").priceMultiplier(3f).build());
                add(City.builder().cityName("????rnak").priceMultiplier(1f).build());
                add(City.builder().cityName("Tekirda??").priceMultiplier(3f).build());
                add(City.builder().cityName("Tokat").priceMultiplier(6f).build());
                add(City.builder().cityName("Trabzon").priceMultiplier(3f).build());
                add(City.builder().cityName("Tunceli").priceMultiplier(1f).build());
                add(City.builder().cityName("U??ak").priceMultiplier(1f).build());
                add(City.builder().cityName("Van").priceMultiplier(3f).build());
                add(City.builder().cityName("Yalova").priceMultiplier(1f).build());
                add(City.builder().cityName("Yozgat").priceMultiplier(1f).build());
                add(City.builder().cityName("Zonguldak").priceMultiplier(1f).build());
            }
        };

        for (City city : cities) {
            citiesService.save(city);
        }

        ArrayList<Account> accounts = new ArrayList<>() {
            {
                add(Account.builder()
                        .identity(12345678901L)
                        .name("Enes")
                        .surname("Baltac??")
                        .email("enes@gmail.com")
                        .age(24)
                        .city(citiesService.getCityById(40L))
                        .build());
                add(Account.builder()
                        .identity(12345678902L)
                        .name("Nazif")
                        .surname("??lbek")
                        .email("nazif@gmail.com")
                        .age(30)
                        .city(citiesService.getCityById(7L))
                        .build());
                add(Account.builder()
                        .identity(12345678903L)
                        .name("??rem")
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