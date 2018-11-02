

public class Example2
{
    public static final String API_ENDPOINT = "https://vrs.africaprudential.com/Api/V2";

    public static final String API_USER = "484_appdev@africaprudential.com";
    public static final String API_PASSPHRASE = "a774b3a81c25ca5d80d0ecdchangepassphrase";


    public static void main(String[] args) {
        GraphqlClient client = new GraphqlClient(API_ENDPOINT);
        String token = client.GetLoginToken(API_USER, API_PASSPHRASE);

        client.changeUrl(API_ENDPOINT+"?token="+token);

        if (!client.IsLoggedIn())
        {
            System.out.println("Was not able to log in!");
            System.exit(1);
        }


        GraphqlClient.Job job = client.CreateEmailJob("Test","My subject");

        System.out.println(job.id);
        System.out.println("Success!");
    }
}
