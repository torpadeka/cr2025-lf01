package exercise.the_bloaters;

public class MethodObject {

	class Account {
		private int delta() {
			return 10;
		}

		public int gamma(int inputVal, int quantity, int yearToDate) {
			return new GammaCalculator(this).gamma(inputVal, quantity, yearToDate);
		}
	}

	class GammaCalculator {
		private Account account;

		public GammaCalculator(Account account) {
			this.account = account;
		}

		public int gamma(int inputVal, int quantity, int yearToDate) {
			int importantValue1 = (inputVal * quantity) + account.delta();
			int importantValue2 = (inputVal * yearToDate) + 100;
			if ((yearToDate - importantValue1) > 100) {
				importantValue2 -= 20;
			}
			int importantValue3 = importantValue2 * 7;
			// and so on�
			return importantValue3 - 2 * importantValue1;
		}
	}

	private void test() {
		Account account = new Account();
		System.out.println(account.gamma(15, 10, 2010));

	}

	public static void main(String[] args) {
		MethodObject p = new MethodObject();
		p.test();
	}

}
