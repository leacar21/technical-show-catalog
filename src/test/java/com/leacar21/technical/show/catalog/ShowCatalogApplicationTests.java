package com.leacar21.technical.show.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.CollectionUtils;

import com.leacar21.technical.show.catalog.dto.ShowDTO;
import com.leacar21.technical.show.catalog.persistence.dao.ShowDAO;
import com.leacar21.technical.show.catalog.persistence.model.AuditoriumFunctionLayout;
import com.leacar21.technical.show.catalog.persistence.model.Function;
import com.leacar21.technical.show.catalog.persistence.model.Section;
import com.leacar21.technical.show.catalog.persistence.model.Show;
import com.leacar21.technical.show.catalog.services.ShowCatalogService;

@SpringBootTest
class ShowCatalogApplicationTests {

    Logger log = LoggerFactory.getLogger(ShowCatalogApplicationTests.class);

    private static final String UUID_SHOW_1 = "cff11aa1-296f-11ec-913c-18c04d3416fd";
    private static final String UUID_SHOW_2 = "cff22aa2-296f-11ec-913c-18c04d3416fd";
    private static final String UUID_SHOW_3 = "cff33aa3-296f-11ec-913c-18c04d3416fd";
    private static final String UUID_SHOW_4 = "cff44aa4-296f-11ec-913c-18c04d3416fd";
    private static final String UUID_SHOW_5 = "cff55aa5-296f-11ec-913c-18c04d3416fd";

    private static final String NAME_SHOW_1 = "Show 1";
    private static final String NAME_SHOW_2 = "Show 2";
    private static final String NAME_SHOW_3 = "Show 3";
    private static final String NAME_SHOW_4 = "Show 4";
    private static final String NAME_SHOW_5 = "Show 5";

    @Autowired
    private ShowCatalogService showCatalogService;

    @MockBean
    private ShowDAO showDAO;

    @Test
    void showsGetAll1Test() {

        // Test All
        Mockito.when(this.showDAO.findAll(true)).thenReturn(this.buildListShow());

        List<ShowDTO> result = this.showCatalogService.getAll(true, this.stringToDate("2021-02-15T00:00:00"),
                this.stringToDate("2022-02-15T00:00:00"), BigDecimal.valueOf(100), BigDecimal.valueOf(10000), null, null);

        assertTrue(!CollectionUtils.isEmpty(result));
        assertEquals(5, result.size());
        assertEquals(2, result.stream().filter(s -> UUID_SHOW_1.equals(s.getCode())).findFirst().get().getFunctions().size());
        assertEquals(2, result.stream().filter(s -> UUID_SHOW_2.equals(s.getCode())).findFirst().get().getFunctions().size());
        assertEquals(2, result.stream().filter(s -> UUID_SHOW_3.equals(s.getCode())).findFirst().get().getFunctions().size());
        assertEquals(5, result.stream().filter(s -> UUID_SHOW_4.equals(s.getCode())).findFirst().get().getFunctions().size());
        assertEquals(1, result.stream().filter(s -> UUID_SHOW_5.equals(s.getCode())).findFirst().get().getFunctions().size());

    }

    @Test
    void showsGetAll2Test() {

        // Test Empty by Date >
        Mockito.when(this.showDAO.findAll(true)).thenReturn(this.buildListShow());

        List<ShowDTO> result = this.showCatalogService.getAll(true, this.stringToDate("2022-02-15T00:00:00"),
                this.stringToDate("2023-02-15T00:00:00"), BigDecimal.valueOf(100), BigDecimal.valueOf(3000), null, null);

        assertTrue(CollectionUtils.isEmpty(result));

    }

    @Test
    void showsGetAll3Test() {

        // Test Empty by Date <
        Mockito.when(this.showDAO.findAll(true)).thenReturn(this.buildListShow());

        List<ShowDTO> result = this.showCatalogService.getAll(true, this.stringToDate("2020-02-15T00:00:00"),
                this.stringToDate("2020-02-15T00:00:00"), BigDecimal.valueOf(100), BigDecimal.valueOf(3000), null, null);

        assertTrue(CollectionUtils.isEmpty(result));

    }

    @Test
    void showsGetAll4Test() {

        // Test Empty by Price <
        Mockito.when(this.showDAO.findAll(true)).thenReturn(this.buildListShow());

        List<ShowDTO> result = this.showCatalogService.getAll(true, this.stringToDate("2022-02-15T00:00:00"),
                this.stringToDate("2023-02-15T00:00:00"), BigDecimal.valueOf(100), BigDecimal.valueOf(200), null, null);

        assertTrue(CollectionUtils.isEmpty(result));

    }

    @Test
    void showsGetAll5Test() {

        // Test Empty by Price >
        Mockito.when(this.showDAO.findAll(true)).thenReturn(this.buildListShow());

        List<ShowDTO> result = this.showCatalogService.getAll(true, this.stringToDate("2022-02-15T00:00:00"),
                this.stringToDate("2023-02-15T00:00:00"), BigDecimal.valueOf(10000), BigDecimal.valueOf(20000), null, null);

        assertTrue(CollectionUtils.isEmpty(result));

    }

    @Test
    void showsGetAll6Test() {

        // Test Empty (only priceTo)
        Mockito.when(this.showDAO.findAll(true)).thenReturn(this.buildListShow());

        List<ShowDTO> result = this.showCatalogService.getAll(true, null, null, null, BigDecimal.valueOf(50), null, null);

        assertTrue(CollectionUtils.isEmpty(result));

    }

    @Test
    void showsGetAll7Test() {

        // Test Empty (only priceFrom)
        Mockito.when(this.showDAO.findAll(true)).thenReturn(this.buildListShow());

        List<ShowDTO> result = this.showCatalogService.getAll(true, null, null, BigDecimal.valueOf(20000), null, null, null);

        assertTrue(CollectionUtils.isEmpty(result));

    }

    @Test
    void showsGetAll8Test() {

        // Test Empty (only dateto)
        Mockito.when(this.showDAO.findAll(true)).thenReturn(this.buildListShow());

        List<ShowDTO> result = this.showCatalogService.getAll(true, null, this.stringToDate("2020-02-15T00:00:00"), null, null, null, null);

        assertTrue(CollectionUtils.isEmpty(result));

    }

    @Test
    void showsGetAll9Test() {

        // Test Empty (only dateFrom)
        Mockito.when(this.showDAO.findAll(true)).thenReturn(this.buildListShow());

        List<ShowDTO> result = this.showCatalogService.getAll(true, this.stringToDate("2022-02-15T00:00:00"), null, null, null, null, null);

        assertTrue(CollectionUtils.isEmpty(result));

    }

    @Test
    void showsGetAll10Test() {

        // Test Filter by Price
        Mockito.when(this.showDAO.findAll(true)).thenReturn(this.buildListShow());

        List<ShowDTO> result = this.showCatalogService.getAll(true, null, null, BigDecimal.valueOf(3000), BigDecimal.valueOf(5000), null,
                null);

        assertTrue(!CollectionUtils.isEmpty(result));
        assertEquals(3, result.size());
        assertEquals(1, result.stream().filter(s -> UUID_SHOW_2.equals(s.getCode())).findFirst().get().getFunctions().size());
        assertEquals(2, result.stream().filter(s -> UUID_SHOW_3.equals(s.getCode())).findFirst().get().getFunctions().size());
        assertEquals(3, result.stream().filter(s -> UUID_SHOW_4.equals(s.getCode())).findFirst().get().getFunctions().size());

    }

    @Test
    void showsGetAll11Test() {

        // Test Filter by Date
        Mockito.when(this.showDAO.findAll(true)).thenReturn(this.buildListShow());

        List<ShowDTO> result = this.showCatalogService.getAll(true, this.stringToDate("2021-10-10T20:00:00"),
                this.stringToDate("2021-10-14T23:00:00"), null, null, null, null);

        assertTrue(!CollectionUtils.isEmpty(result));
        assertEquals(4, result.size());
        assertEquals(2, result.stream().filter(s -> UUID_SHOW_1.equals(s.getCode())).findFirst().get().getFunctions().size());
        assertEquals(2, result.stream().filter(s -> UUID_SHOW_2.equals(s.getCode())).findFirst().get().getFunctions().size());
        assertEquals(1, result.stream().filter(s -> UUID_SHOW_3.equals(s.getCode())).findFirst().get().getFunctions().size());
        assertEquals(1, result.stream().filter(s -> UUID_SHOW_5.equals(s.getCode())).findFirst().get().getFunctions().size());

    }

    @Test
    void showsGetAll12Test() {

        // Test Filter by Date and Price
        Mockito.when(this.showDAO.findAll(true)).thenReturn(this.buildListShow());

        List<ShowDTO> result = this.showCatalogService.getAll(true, this.stringToDate("2021-10-10T20:00:00"),
                this.stringToDate("2021-10-14T23:00:00"), BigDecimal.valueOf(3000), BigDecimal.valueOf(5000), null, null);

        assertTrue(!CollectionUtils.isEmpty(result));
        assertEquals(2, result.size());
        assertEquals(1, result.stream().filter(s -> UUID_SHOW_2.equals(s.getCode())).findFirst().get().getFunctions().size());
        assertEquals(1, result.stream().filter(s -> UUID_SHOW_3.equals(s.getCode())).findFirst().get().getFunctions().size());
    }

    // =================

    private List<Show> buildListShow() {

        // -------
        var listFunction1 = this.buildListFunction1();
        var listFunction2 = this.buildListFunction2();
        var listFunction3 = this.buildListFunction3();
        var listFunction4 = this.buildListFunction4();
        var listFunction5 = this.buildListFunction5();

        // -------

        var show1 = Show.builder().code(UUID.fromString(UUID_SHOW_1)).enabled(true).name(NAME_SHOW_1).functions(listFunction1).build();
        var show2 = Show.builder().code(UUID.fromString(UUID_SHOW_2)).enabled(true).name(NAME_SHOW_2).functions(listFunction2).build();
        var show3 = Show.builder().code(UUID.fromString(UUID_SHOW_3)).enabled(true).name(NAME_SHOW_3).functions(listFunction3).build();
        var show4 = Show.builder().code(UUID.fromString(UUID_SHOW_4)).enabled(true).name(NAME_SHOW_4).functions(listFunction4).build();
        var show5 = Show.builder().code(UUID.fromString(UUID_SHOW_5)).enabled(true).name(NAME_SHOW_5).functions(listFunction5).build();

        var listShow = new LinkedList<Show>();
        listShow.add(show1);
        listShow.add(show2);
        listShow.add(show3);
        listShow.add(show4);
        listShow.add(show5);

        return listShow;
    }

    private LinkedList<Function> buildListFunction1() {
        var listFunction = new LinkedList<Function>();
        var sectionList1 = List.of( //
                Section.builder().code(UUID.randomUUID()).name("Section111").seatPrice(BigDecimal.valueOf(1000)).build(), //
                Section.builder().code(UUID.randomUUID()).name("Section112").seatPrice(BigDecimal.valueOf(1500)).build() //
        );
        this.addSectionsToFunction(listFunction, sectionList1, "Layout11", "2021-10-10T20:00:00");

        // --

        var sectionList2 = List.of( //
                Section.builder().code(UUID.randomUUID()).name("Section121").seatPrice(BigDecimal.valueOf(1000)).build(), //
                Section.builder().code(UUID.randomUUID()).name("Section122").seatPrice(BigDecimal.valueOf(1500)).build(), //
                Section.builder().code(UUID.randomUUID()).name("Section122").seatPrice(BigDecimal.valueOf(2000)).build() //
        );
        this.addSectionsToFunction(listFunction, sectionList2, "Layout12", "2021-10-11T21:00:00");
        return listFunction;
    }

    // -----------------

    private LinkedList<Function> buildListFunction2() {
        var listFunction = new LinkedList<Function>();
        var sectionList1 = List.of( //
                Section.builder().code(UUID.randomUUID()).name("Section211").seatPrice(BigDecimal.valueOf(2000)).build(), //
                Section.builder().code(UUID.randomUUID()).name("Section212").seatPrice(BigDecimal.valueOf(2500)).build() //
        );
        this.addSectionsToFunction(listFunction, sectionList1, "Layout21", "2021-10-12T19:00:00");

        // --

        var sectionList2 = List.of( //
                Section.builder().code(UUID.randomUUID()).name("Section221").seatPrice(BigDecimal.valueOf(2000)).build(), //
                Section.builder().code(UUID.randomUUID()).name("Section222").seatPrice(BigDecimal.valueOf(2500)).build(), //
                Section.builder().code(UUID.randomUUID()).name("Section222").seatPrice(BigDecimal.valueOf(3000)).build() //
        );
        this.addSectionsToFunction(listFunction, sectionList2, "Layout22", "2021-10-13T19:30:00");
        return listFunction;
    }

    // -----------------

    private LinkedList<Function> buildListFunction3() {
        var listFunction = new LinkedList<Function>();
        var sectionList1 = List.of( //
                Section.builder().code(UUID.randomUUID()).name("Section311").seatPrice(BigDecimal.valueOf(4000)).build(), //
                Section.builder().code(UUID.randomUUID()).name("Section312").seatPrice(BigDecimal.valueOf(4500)).build() //
        );
        this.addSectionsToFunction(listFunction, sectionList1, "Layout31", "2021-10-14T21:00:00");

        // --

        var sectionList2 = List.of( //
                Section.builder().code(UUID.randomUUID()).name("Section321").seatPrice(BigDecimal.valueOf(4000)).build(), //
                Section.builder().code(UUID.randomUUID()).name("Section322").seatPrice(BigDecimal.valueOf(4500)).build(), //
                Section.builder().code(UUID.randomUUID()).name("Section322").seatPrice(BigDecimal.valueOf(5000)).build() //
        );
        this.addSectionsToFunction(listFunction, sectionList2, "Layout32", "2021-10-15T22:00:00");
        return listFunction;
    }

    // -----------------

    private LinkedList<Function> buildListFunction4() {
        var listFunction = new LinkedList<Function>();
        var sectionList1 = List.of( //
                Section.builder().code(UUID.randomUUID()).name("Section411").seatPrice(BigDecimal.valueOf(1000)).build());
        this.addSectionsToFunction(listFunction, sectionList1, "Layout41", "2021-10-16T22:00:00");

        // --

        var sectionList2 = List.of( //
                Section.builder().code(UUID.randomUUID()).name("Section421").seatPrice(BigDecimal.valueOf(2000)).build());
        this.addSectionsToFunction(listFunction, sectionList2, "Layout42", "2021-10-17T22:00:00");

        // --

        var sectionList3 = List.of( //
                Section.builder().code(UUID.randomUUID()).name("Section431").seatPrice(BigDecimal.valueOf(3000)).build());
        this.addSectionsToFunction(listFunction, sectionList3, "Layout43", "2021-10-18T22:00:00");

        // --

        var sectionList4 = List.of( //
                Section.builder().code(UUID.randomUUID()).name("Section441").seatPrice(BigDecimal.valueOf(4000)).build());
        this.addSectionsToFunction(listFunction, sectionList4, "Layout44", "2021-10-19T22:00:00");

        // --

        var sectionList5 = List.of( //
                Section.builder().code(UUID.randomUUID()).name("Section451").seatPrice(BigDecimal.valueOf(5000)).build());
        this.addSectionsToFunction(listFunction, sectionList5, "Layout45", "2021-10-20T22:00:00");
        return listFunction;
    }

    // -----------------

    private LinkedList<Function> buildListFunction5() {
        var listFunction = new LinkedList<Function>();
        var sectionList1 = List.of( //
                Section.builder().code(UUID.randomUUID()).name("Section511").seatPrice(BigDecimal.valueOf(5500)).build(), //
                Section.builder().code(UUID.randomUUID()).name("Section512").seatPrice(BigDecimal.valueOf(6000)).build(), //
                Section.builder().code(UUID.randomUUID()).name("Section513").seatPrice(BigDecimal.valueOf(6500)).build(), //
                Section.builder().code(UUID.randomUUID()).name("Section514").seatPrice(BigDecimal.valueOf(7000)).build(), //
                Section.builder().code(UUID.randomUUID()).name("Section515").seatPrice(BigDecimal.valueOf(7500)).build(), //
                Section.builder().code(UUID.randomUUID()).name("Section516").seatPrice(BigDecimal.valueOf(8000)).build() //
        );
        this.addSectionsToFunction(listFunction, sectionList1, "Layout51", "2021-10-10T21:00:00");

        return listFunction;
    }

    // =================

    private void addSectionsToFunction(LinkedList<Function> listFunction, List<Section> sectionList, String layoutName, String strDate) {
        var auditoriumFunctionLayout = AuditoriumFunctionLayout.builder().auditoriumCode(UUID.randomUUID()).name(layoutName)
                .sections(sectionList).build();
        var function = Function.builder().code(UUID.randomUUID()).date(this.stringToDate(strDate)).enabled(true)
                .auditoriumFunctionLayout(auditoriumFunctionLayout).build();
        listFunction.add(function);
    }

    // =================

    private Date stringToDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            return formatter.parse(date);
        } catch (Exception ex) {
            this.log.warn("Error parsing date: ", ex);
        }
        return null;
    }

}
