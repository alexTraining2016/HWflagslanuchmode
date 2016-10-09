package comalexpolyanskyi.github.hwflagslanuchmode;

public class SomeApi {
    private boolean visibilityMessageBtn;

    public boolean isVisibleMessageBtn(){
        return visibilityMessageBtn;
    }

    public void setVisibilityMessageBtn(){
        visibilityMessageBtn = BuildConfig.DEBUG;
    }

    public int getSeasonType(){
        return 1;
    }

    public String getSeason(){
        int seasonType = getSeasonType();
        if(seasonType == 12 || seasonType <= 2){
            return "winter";
        }else if(seasonType > 2 && seasonType <= 5){
            return "spring";
        }else if(seasonType > 5 && seasonType <= 8){
            return "summer";
        }else if(seasonType > 8 && seasonType <= 11){
            return "autumn";
        }
        return "invalid data";
    }
}
