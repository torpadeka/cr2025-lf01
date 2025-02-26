package exercise.the_bloaters;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

import exercise.the_bloaters.ParameterizeObject.Transaction;

public class ParameterizeObject {

	class DateRange {
		Date start;
		Date end;

		public DateRange(Date start, Date end) {
			this.start = start;
			this.end = end;
		}
	}

	class Account {

		private Vector<Transaction> transactions = new Vector<Transaction>();

		public Account() {
			transactions.add(new Transaction(1000, new Date(1000)));
			transactions.add(new Transaction(1200, new Date(1100)));
			transactions.add(new Transaction(1500, new Date(1200)));
			transactions.add(new Transaction(1300, new Date(1300)));
		}

		public double getFlowBetween(DateRange dateRange) {
			double result = 0;
			Enumeration<Transaction> e = transactions.elements();
			while (e.hasMoreElements()) {
				Transaction each = (Transaction) e.nextElement();
				if (each.getDate().compareTo(dateRange.start) >= 0 && each.getDate().compareTo(dateRange.end) <= 0) {
					result += each.getValue();
				}
			}
			return result;
		}
	}

	class Transaction {
		private Date chargeDate;
		private double value;

		public Transaction(double value, Date chargeDate) {
			this.value = value;
			this.chargeDate = chargeDate;
		}

		public Date getDate() {
			return chargeDate;
		}

		public double getValue() {
			return value;
		}
	}

	private void test() {
		Account account = new Account();
		double flow = account.getFlowBetween(new DateRange(new Date(1050), new Date(1250)));

		System.out.println(flow);

	}

	public static void main(String[] args) {
		ParameterizeObject p = new ParameterizeObject();
		p.test();
	}

}
