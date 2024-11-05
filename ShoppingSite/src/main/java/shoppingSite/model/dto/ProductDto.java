package shoppingSite.model.dto;

import lombok.Data;

@Data
public class ProductDto {
	private Integer Pid;
	private Integer Ptype;
	private String Pname;
	private Integer Price;
	private Integer Pstock;
	private Integer Totalsold;
	private Double Star;	
	private boolean PStatus;
}
