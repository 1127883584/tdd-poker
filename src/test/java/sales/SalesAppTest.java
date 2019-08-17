package sales;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SalesAppTest {
	@Mock
	SalesReportDao salesReportDao;
	@InjectMocks
	SalesApp salesApp = new SalesApp();

//	@Test
//	public void testGenerateReport() {
//
//		SalesApp salesApp = new SalesApp();
//		salesApp.generateSalesActivityReport("DUMMY", 1000, false, false);
//
//	}

	@Test
	public void testCheckDate(){
		//given
		SalesApp salesApp = new SalesApp();
		Sales sales = spy(Sales.class);
		doReturn(new Date(new Date().getTime() + 24*60*60*1000)).when(sales).getEffectiveTo();
		doReturn(new Date(new Date().getTime() - 24*60*60*1000)).when(sales).getEffectiveFrom();
		//when
		boolean isCheckDate = salesApp.checkDate(sales);
		//then
		Assert.assertFalse(isCheckDate);
	}

	@Test
	public void testFilterList(){
		//given
		Sales sales = new Sales();
		SalesReportData salesReportData = mock(SalesReportData.class);
		when(salesReportData.getType()).thenReturn("SalesActivity");
		List<SalesReportData> reportDataList = Arrays.asList(new SalesReportData(),salesReportData);
		when(salesReportDao.getReportData(sales)).thenReturn(reportDataList);
		//when
		List<SalesReportData> filteredReportDataList = new ArrayList<>();
		filteredReportDataList = salesApp.filterList(true,filteredReportDataList,reportDataList);
		//then
		Assert.assertEquals(1, filteredReportDataList.size());
		Assert.assertEquals("SalesActivity", filteredReportDataList.get(0).getType());
	}

	@Test
	public void testFilterList_return_null(){
		//given
		Sales sales = new Sales();
		SalesReportData salesReportData = mock(SalesReportData.class);
		when(salesReportData.getType()).thenReturn("SalesActivity");
		when(salesReportData.isConfidential()).thenReturn(true);
		List<SalesReportData> reportDataList = Arrays.asList(new SalesReportData(),salesReportData);
		when(salesReportDao.getReportData(sales)).thenReturn(reportDataList);
		//when
		List<SalesReportData> filteredReportDataList = new ArrayList<>();
		filteredReportDataList = salesApp.filterList(false,filteredReportDataList,reportDataList);
		//then
		Assert.assertEquals(0, filteredReportDataList.size());
	}

	@Test
	public void testGetTempList_return_3_when_in_maxRow(){
		//given
		Sales sales = new Sales();
		List<SalesReportData> reportDataList = Arrays.asList(new SalesReportData(), new SalesReportData(), new SalesReportData());
		when(salesReportDao.getReportData(sales)).thenReturn(reportDataList);
		//when
		List<SalesReportData> filteredReportDataList = new ArrayList<>();
		filteredReportDataList = salesApp.getTempList(10, reportDataList);
		//then
		Assert.assertEquals(3, filteredReportDataList.size());
	}

	@Test
	public void testGetTempList_return_2_when_over_maxRow(){
		//given
		Sales sales = new Sales();
		List<SalesReportData> reportDataList = Arrays.asList(new SalesReportData(), new SalesReportData(), new SalesReportData());
		when(salesReportDao.getReportData(sales)).thenReturn(reportDataList);
		//when
		List<SalesReportData> filteredReportDataList = new ArrayList<>();
		filteredReportDataList = salesApp.getTempList(2, reportDataList);
		//then
		Assert.assertEquals(2, filteredReportDataList.size());
	}
}
