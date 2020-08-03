package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
    private Order order;
	private static final String EACH_ITEM_LINE = "%s\t%s\t%s\t%s\n";
	private static final String TOTAL_LINE = "%s\t%s";
	private static final double TAX_PERCENT = 0.10;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder printInfomation = new StringBuilder();
		printInfomation.append("======Printing Orders======\n");
        printInfomation.append(order.getCustomerName());
        printInfomation.append(order.getCustomerAddress());
		double totalSalesTax = 0d;
		double totalAmount = 0d;
		for (LineItem lineItem : order.getLineItems()) {
			printInfomation.append(String.format(EACH_ITEM_LINE,lineItem.getDescription(),lineItem.getPrice(),lineItem.getQuantity(),lineItem.totalAmount()));
            double salesTax = lineItem.totalAmount() * TAX_PERCENT;
            totalSalesTax += salesTax;
            totalAmount += lineItem.totalAmount() + salesTax;
		}
		printInfomation.append(String.format(TOTAL_LINE,"Sales Tax",totalSalesTax)).append(String.format(TOTAL_LINE,"Total Amount",totalAmount));
		return printInfomation.toString();
	}
}