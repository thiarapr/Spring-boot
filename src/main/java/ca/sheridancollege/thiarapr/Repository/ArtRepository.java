package ca.sheridancollege.thiarapr.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.thiarapr.beans.Art;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ArtRepository {
	private NamedParameterJdbcTemplate jdbc;
	
	public void addArt(Art art) {
		MapSqlParameterSource parametrers=new MapSqlParameterSource();
		
		String query="INSERT INTO art (name,price, quantity) VALUES(:na,:pr,:qn) ";
		parametrers.addValue("na",art.getName());
		parametrers.addValue("pr",art.getPrice());
		parametrers.addValue("qn",art.getQuantity());
		
		jdbc.update(query, parametrers);
	}
	public ArrayList<Art> getArt(){
		ArrayList<Art> art = new ArrayList<>();
		MapSqlParameterSource parameters=new MapSqlParameterSource();
		String query="SELECT * FROM art";
		List<Map<String,Object>> rows=
				jdbc.queryForList(query, parameters);
		for(Map<String,Object>row:rows) {
			Art a=new Art();
	        a.setId((int)row.get("id"));
	        a.setName((String)row.get("name"));
	        a.setPrice((Double)row.get("price"));
	        a.setQuantity((int)row.get("quantity"));
	       
	        
	        art.add(a);

		}
		return art;
		
	}
	public void deletebyid(int id) {
		MapSqlParameterSource parametrers=new MapSqlParameterSource();
		String query="DELETE  FROM art WHERE id=:id";
		parametrers.addValue("id",id);
		jdbc.update(query,parametrers);
		
	}
  public Art updateQuantity(int id) {
	  Art a = new Art();
		MapSqlParameterSource parameters=new MapSqlParameterSource();
		String query = "Update art \r\n"
				+ "Set quantity = quantity -1\r\n"
				+ "Where id=:id;";
		parameters.addValue("id", id);
		parameters.addValue("quantity",a.getQuantity());	
	jdbc.update(query,parameters);
	return a;
  }
}
