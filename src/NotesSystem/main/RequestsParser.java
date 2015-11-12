package NotesSystem.main;

/**
 * Created by Alex on 04.11.2015.
 */
public class RequestsParser {
    private int _userId;
    private String _userName;
    private String _pass;
    private int _tagId;
    private String _taggData;

    public void SetUserId(int id) {
        _userId = id;
    }

    public String Parse(String str) {
        String s = new String();

        int operId = -1;
        ///
        byte stage = 0;
        StringBuilder buff = new StringBuilder();
        int buffId = 0;
        String buffData = new String();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == CommonData.SEP) {
                switch(stage)
                {
                    case 0:         //*** Read command ID. ***
                        operId = Integer.parseInt(buff.toString());
                        switch (operId)
                        {
                            case 0: // Try to login
                                stage = 1;

                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                            case 8:
                                break;
                        }

                        break;
                    case 1:         //*** Read username. ***
                        _userName = buff.toString();
                        stage++;
                        break;
                    case 2:         // *** Read user's password. ***
                        _pass = buff.toString();
                        stage=0;
                        break;
                    case 3:         //*** Read tag id. ***
                        _tagId = Integer.parseInt(buff.toString());
                        stage++;
                        break;
                    case 4:         // *** Read tag data. ***
                        _taggData = buff.toString();
                        stage=0;
                        break;
                }
                buff.delete(0, buff.length());
            }
            else buff.append(str.charAt(i));
        }

        /*

        * */


        return s;

    }

}
