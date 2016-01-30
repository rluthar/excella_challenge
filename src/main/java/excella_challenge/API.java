package excella_challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;



public class API {
	
	@POST
	@Path("/isAnagram")
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response isAnagram(String[][] words, @Context HttpServletRequest request) {
		Gson gson = new Gson();
		boolean[] retData = isAnagram(words);
		return Response.status(200).entity(retData).build();
	}
	
	@POST
	@Path("/isPalindrome")
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response isPalindrome(List<String> words, @Context HttpServletRequest request) {
		Gson gson = new Gson();
		List<Boolean> retData = isPalindrome(words);
		return Response.status(200).entity(retData).build();
	}
	
	private static boolean[] isAnagram(String[][] values) {
		boolean[] bool = new boolean[values.length];
		for(int i = 0; i < values.length; i++) {
			String[] words = values[i];
			
			char[] word1 = words[0].toCharArray();
			char[] word2 = words[1].toCharArray();
			
			Arrays.sort(word1);
			Arrays.sort(word2);
			boolean equal = true;
			if(word1.length != word2.length) {
				equal = false;
			} else {
				for(int x = 0; x < word1.length; x++) {
					if(word1[x] != word2[x]) {
						equal = false;
						break;
					}
				}
			}
			
			bool[i] = equal;
		}
		return bool;
	}
	
	private static List<Boolean> isPalindrome(List<String> words) {
		List<Boolean> bool = new ArrayList<Boolean>();
		
		for(String word : words) {
			char[] array = word.toCharArray();
			char[] array2 = new char[array.length];
			for(int i = 0; i < array.length; i++) {
				array2[i] = array[array.length - i - 1];
			}
			
			boolean equal = true;
			for(int i = 0; i < array.length; i++) {
				if(array[i] != array2[i]) {
					equal = false;
					break;
				}
			}
			
			bool.add(equal);
			
		}
		
		return bool;
	}
 	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
