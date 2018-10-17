import com.andy.jwt.util.JwtToken;
import com.auth0.jwt.interfaces.Claim;

import java.util.Map;

/**
 * @author Leone
 * @since 2018-04-16
 **/
public class JwtTest {

    public static void main(String[] args) throws Exception {

        String token = JwtToken.createToken();
        String tokenExpire = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJvcmciOiLku4rml6XlpLTmnaEiLCJuYW1lIjoiamFtZXMiLCJleHAiOjE1MjM4NDM1NDksImFnZSI6MjN9.CS-PXcfpmjLErjNVbfIYlmEDcYhz4pyZ7QimTD2Xcg0";

        System.out.println("Token="+ token);
        Map<String, String> result = JwtToken.verifyToken(token);
        System.out.println(result);

    }


}
