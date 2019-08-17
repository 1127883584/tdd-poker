package sales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SalesApp {

	SalesDao salesDao;
	SalesReportDao salesReportDao;

	public void generateSalesActivityReport(String salesId, int maxRow, boolean isNatTrade, boolean isSupervisor) {

		List<String> headers = null;
		
		List<SalesReportData> filteredReportDataList = new ArrayList<SalesReportData>();
		
		if (salesId == null) {
			return;
		}
		
		Sales sales = salesDao.getSalesBySalesId(salesId);

		if (checkDate(sales)) return;
		
		List<SalesReportData> reportDataList = salesReportDao.getReportData(sales);

		filteredReportDataList = filterList(isSupervisor, filteredReportDataList, reportDataList);
		
		List<SalesReportData> tempList = getTempList(maxRow, reportDataList);

		filteredReportDataList = tempList;
		
		if (isNatTrade) {
			headers = Arrays.asList("Sales ID", "Sales Name", "Activity", "Time");
		} else {
			headers = Arrays.asList("Sales ID", "Sales Name", "Activity", "Local Time");
		}
		
		SalesActivityReport report = this.generateReport(headers, reportDataList);
		
		EcmService ecmService = new EcmService();
		ecmService.uploadDocument(report.toXml());
		
	}

	protected List<SalesReportData>  getTempList(int maxRow, List<SalesReportData> reportDataList) {
		List<SalesReportData> tempList = new ArrayList<>();
		for (int i=0; i < reportDataList.size() && i < maxRow; i++) {
			tempList.add(reportDataList.get(i));
		}
		return tempList;
	}

	protected List<SalesReportData> filterList(boolean isSupervisor, List<SalesReportData> filteredReportDataList, List<SalesReportData> reportDataList) {
		for (SalesReportData data : reportDataList) {
			if ("SalesActivity".equalsIgnoreCase(data.getType())) {
				if (data.isConfidential()) {
					if (isSupervisor) {
						filteredReportDataList.add(data);
					}
				}else {
					filteredReportDataList.add(data);
				}
			}
		}
		return filteredReportDataList;
	}

	protected boolean checkDate(Sales sales) {
		Date today = new Date();
		if (today.after(sales.getEffectiveTo())
				|| today.before(sales.getEffectiveFrom())){
			return true;
		}
		return false;
	}

	private SalesActivityReport generateReport(List<String> headers, List<SalesReportData> reportDataList) {
		// TODO Auto-generated method stub
		return null;
	}

}
