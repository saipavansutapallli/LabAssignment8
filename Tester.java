package lab_8;

import java.util.*;
import java.util.stream.Collectors;

public class Tester {
	public static void main(String args[]) {

		List<Transaction> trans = getTransactions();
		List<Trader> cities = (List<Trader>) trans.stream().map(s -> s.getTrader()).distinct()
				.collect(Collectors.toList());
		System.out.println("Ques:1");
		List<Transaction> list = trans.stream()
				.filter(s -> s.getYear() == 2011)
				.sorted((o1, o2) -> Integer.compare(o1.getValue(), o2.getValue())).collect(Collectors.toList());
		list.forEach(System.out::println);
		System.out.println("Ques:2");
		List<String> Uniquecities = (List<String>) cities.stream()
				.map(s -> s.getCity()).distinct()
				.collect(Collectors.toList());
		Uniquecities.forEach(System.out::println);
		System.out.println("Ques:3");
		List<Trader> delhiTraders = cities.stream()
				.filter(d -> d.getCity().equals("delhi"))
				.sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
		delhiTraders.forEach(System.out::println);
		System.out.println("Ques:4");
		List<Trader> traderNames = cities.stream()
				.sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
				.collect(Collectors.toList());
		traderNames.forEach(System.out::println);
		System.out.println("Ques:5");
		boolean traderInJaipur = cities.stream()
				.anyMatch(j -> j.getCity().equals("jaipur"));
		if (traderInJaipur)
			System.out.println("Traders are available inJaipur");
		else
			System.out.println("Traders are not available in Jaipur");
		System.out.println("Ques:6");
		List<Trader> delhiTrader = cities.stream().filter(s -> s.getCity().equals("delhi"))
				.collect(Collectors.toList());
		List<Integer> delhiTradersList = trans.stream().filter(c -> c.getTrader().getCity().equals("delhi"))
				.map(e -> e.getValue()).collect(Collectors.toList());
		delhiTradersList.forEach(System.out::println);
		System.out.println("Ques:7");
		OptionalInt maxValue = trans.stream().mapToInt(d -> d.getValue()).max();
		System.out.println(maxValue.orElse(-1));
		System.out.println("Ques:8");
		OptionalInt minValue = trans.stream().mapToInt(d -> d.getValue()).min();
		System.out.println(minValue.orElse(-1));

	}

	private static List<Transaction> getTransactions() {
		Trader ram = new Trader("ram", "delhi");
		Trader kapil = new Trader("kapil", "noida");
		Trader raj = new Trader("raj", "banglore");
		Trader ekta = new Trader("ekta", "banglore");
		List<Transaction> transactions = Arrays.asList(new Transaction(ram, 2011, 300),new Transaction(ram, 2012, 1000), 
				new Transaction(kapil, 2011, 400), new Transaction(raj, 2012, 710),
				new Transaction(ekta, 2012, 700), new Transaction(ekta, 2012, 950));
		return transactions;
	}
}
