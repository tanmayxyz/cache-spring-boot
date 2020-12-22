package com.tanmay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Min(value = 0,message = "{car.id.less-than-zero}")
	private Integer id;
	@Column(name = "model_name")
	@NotBlank(message = "{car.modelname.not-blank}")
	private String modelName;
	@NotNull(message = "{car.price.not-null}")
	@Min(value = 0,message = "{car.price.less-than-zero}")
	private  Integer price;
	@Column(name = "model_number")
	@NotBlank(message = "{car.modelnumber.not-blank}")
	private String modelNumber;
	@Column(name = "showroom_code")
	@NotBlank(message = "{car.showroomcode.not-null}")
	private String showRoomCode;
	private boolean avalible;
	@Column(name = "assigned_employee")
	@NotBlank(message = "{car.assignedemployee.not-blank}")
	private String assignedEmployee;

}
