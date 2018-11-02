import java.util.ArrayList;

public class Example3
{
    public static final String API_ENDPOINT = "https://vrs.africaprudential.com/api/v2";

    public static final String API_USER = "484_appdev@africaprudential.com";
    public static final String API_PASSPHRASE = "a774b3a81c25ca5d80d0ecdchangepassphrase";


    public static void main(String[] args) {
        ZenterApi api = new ZenterApi(API_ENDPOINT);

        if (!api.Login(API_USER, API_PASSPHRASE))
        {
            System.out.println("Was not able to log in!");
            System.exit(1);
        }

        ArrayList<Recipient> arr = new ArrayList<Recipient>();
		arr.add(new Recipient("Ingimar 1", "ingimar+1@zenter.is"));
		arr.add(new Recipient("Ingimar 2", "ingimar+2@zenter.is"));
		arr.add(new Recipient("Ingimar 3", "ingimar+3@zenter.is"));
		arr.add(new Recipient("Ingimar 4", "ingimar+4@zenter.is"));
		arr.add(new Recipient("Ingimar 5", "ingimar+5@zenter.is"));


		Job job = api.CreateJob("Test","My subject", "list-Title", arr);

		api.SendJob(job);
        System.out.println("Success!");
    }
}
