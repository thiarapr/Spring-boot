package ca.sheridancollege.thiarapr.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Art {
  private int id;
  private String name;
  private double price;
  private int quantity;
}

