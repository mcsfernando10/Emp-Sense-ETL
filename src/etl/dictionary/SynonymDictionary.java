/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.dictionary;

import etl.constants.StringConstants;
import java.util.HashMap;

/**
 *
 * @author Chinthaka Suren
 */
public class SynonymDictionary {
    private HashMap<String,String[]> words;
    public SynonymDictionary() {
        words=new HashMap<>();
        String[] synonymsForID = new String[]{"id","positive identification","I.D.","badge","instinct","unconscious mind","inherent aptitude","unconscious","USA","Coeur d'Alene Lake","the States","Coeur d'Alene","Yellowstone National Park","Nampa","Idaho","Gem State","capital of Idaho","Salmon","Boise","Snake River","United States of America","Snake","Salmon River","America","Pocatello","U.S.","United States","Idaho Falls","Lewiston","Sun Valley","U.S.A.","US","Twin Falls"};
        String[] synonymsForName = new String[]{"name","last name","surname","file name","street name","brand name","nom de guerre","appellative","linguistic unit","forename","patronymic","false name","place name","first name","middle name","title","nickname","cognomen","domain name","filename","fictitious name","trade name","company name","agnomen","writer's name","given name","appellation","toponym","brand","patronym","denomination","Doing Business As","hypocorism","eponym","computer filename","author's name","metronymic","family name","pet name","designation","marque","DBA","language unit","alias","matronymic","computer file name","signature","assumed name","anonym","pseudonym","misnomer","rename","christen","title","dub","tag","style","label","baptise","baptize","term","entitle","address","call","nickname","refer","recite","itemize","list","number","denote","itemise","identify","enumerate","announce","refer","repute","reputation","appoint","rename","nominate","make","charge","set","fix","limit","determine","specify","define","appoint","co-opt","plant","institute","nominate","constitute","found","establish","pack","kinfolk","family","gens","family line","phratry","kinsfolk","sept","folk","think of","appeal","invoke","drag up","quote","remember","bring up","namedrop","commend","raise","advert","mention","touch on","cross-refer","mean","dredge up","have in mind","speak of the devil","cite","refer","sanction"};
        String[] synonymsForAge = new String[]{"age","newness","chronological age","old","mental age","gestational age","young","youngness","developmental age","mature","fertilization age","oldness","immature","property","new","bone age","fetal age","golden age","Jazz Age","turn of the century","reign","antiquity","epoch","era","historic period","history","nonage","life","minority","age of consent","voting age","eld","majority","drinking age","legal age","time of life","lifespan","lifetime","life-time","develop","dote","get on","turn","maturate","mature","fossilise","senesce","fossilize","develop","mid-sixties","geezerhood","nineties","senility","dotage","seventies","old age","eld","years","sixties","second childhood","time of life","eighties","mid-seventies","mid-nineties","mid-eighties","antique","old","get on","modify","alter","senesce","maturate","mature","change","blue moon","eon","period","years","period of time","month of Sundays","long time","time period","year dot","aeon","macular degeneration","AMD"};
        String[] synonymsForGender = new String[]{"gender","sex","syntactic category","neuter","grammatical gender","feminine","masculine","grammatical category","sexual","femaleness","nonsexual","asexual","bisexuality","maleness","sex","masculinity","sexuality","hermaphroditism","female","feminineness","androgynous","male","androgyny","physiological property"};
        String[] synonymsForMaritalState = new String[]{"civil status","marital-state","province","commonwealth","American state","land","Canadian province","country","Australian state","administrative district","eparchy","Italian region","administrative division","territorial division","Soviet Socialist Republic","respond","represent","supply","articulate","say","sum up","get out","preface","utter","append","lay out","explain","vocalize","add","verbalize","note","answer","announce","tell","misstate","express","vocalise","enunciate","introduce","give tongue to","observe","premise","reply","summarize","present","summarise","remark","give","mention","precede","verbalise","sum","declare","state of grace","unemployment","being","forthcomingness","immaturity","conditionality","integrity","death","office","isomerism","imperfection","nonbeing","immatureness","omnipotence","antagonism","hostility","heterozygosity","unification","perfection","condition","beingness","paternity","level","delegacy","flux","activity","cleavage","disorder","ne plus ultra","motionlessness","damnation","saving grace","employment","preparation","power","receivership","polyvalency","ornamentation","inaction","dead letter","impendence","imminence","wild","imminency","impendency","dependance","obligation","state of nature","stage","separation","homozygosity","state of affairs","enmity","freedom","dependence","motion","dependency","action","degree","polyvalence","point","multivalence","lifelessness","preparedness","plurality","illumination","eternal damnation","utilization","union","annulment","nationhood","medium","relationship","inactiveness","neotony","dystopia","grace","natural state","skillfulness","non-issue","employ","maturity","utopia","tribalism","situation","feeling","multivalency","existence","attribute","kalemia","omniscience","imminentness","temporary state","end","imperfectness","revocation","state of flux","agency","activeness","unity","ground state","conflict","status","enlargement","merchantability","ownership","position","flawlessness","wholeness","destruction","inactivity","readiness","turgor","stillness","matureness","representation","order","government","welfare state","authorities","Soviets","regime","commonwealth","foreign country","estate","commonwealth country","developing country","rogue nation","great power","res publica","body politic","superpower","ally","rogue state","political unit","power","political entity","nation","renegade state","the three estates","Reich","Dominion","world power","suzerain","land","country","sea power","city state","city-state","estate of the realm","major power","propose","submit","put forward","suggest","posit","advise","matrimonial","married","vote","express","refer","denote","solid","theocracy"};
        String[] synonymsForHavingDegree = new String[]{"having degree", "education level"};
        String[] synonymsForJobRole = new String[]{"job role","office","profession","trade","sport","accounting","vocation","employment","post","occupation","confectionery","metier","line of work","treadmill","farming","billet","accountancy","medium","appointment","business","photography","spot","catering","game","craft","biz","situation","line","salt mine","berth","land","career","work","calling","place","activity","position","function","duty","second fiddle","capacity","office","lieu","stead","part","place","position","portfolio","hat","duty","chore","task","ball-buster","scut work","ball-breaker","shitwork","stint","heavy","personation","name part","persona","minor role","characterization","ingenue","enactment","bit part","character","title role","baddie","theatrical role","villain","part","hero","portrayal","heroine","function","use","functional","usefulness","nonfunctional","utility","raison d'etre","purpose","gender role","position","activity","work","workplace","work","production","product","duty","responsibility","obligation"};
        String[] synonymsForTenure = new String[]{"tenure","term","presidency","vice-presidential term","incumbency","administration","presidential term","episcopate","vice-presidency","term of office","advance","upgrade","kick upstairs","elevate","promote","raise","legal right","villeinage","freehold","land tenure","copyhold"};
        String[] synonymsForSalary = new String[]{"salary","wage","regular payment","take-home pay","remuneration","pay","minimum wage","payroll","merit pay","combat pay","pay packet","strike pay","sick pay","paysheet","earnings","pay envelope","double time","found","half-pay","living wage"};
        String[] synonymsForNoOfLeaves = new String[]{"leaves", "holidays"};
        String[] synonymsForDistance = new String[]{"distance","focal length","hyperfocal distance","farawayness","closeness","distant","close","wavelength","spatial arrangement","span","nigh","nearness","leap","farness","way","milage","remoteness","mileage","elevation","far","spacing","yardage","separation","mean distance","minute","hour","interval","remove","wheelbase","near","hour angle","focal distance","piece","region","part","arm's length","altitude","leg","skip distance","light time","wingspread","length","gauge","wingspan","size","indifference","aloofness","time interval","interval","space","point in time","point","leave behind","outstrip","outdistance","hold","maintain","keep","distant"};
        String[] synonymsForDependents = new String[]{"dependents","independency","parasitic","unfree","reliant","babelike","symbiotic","mutually beneficial","myrmecophilous","interdependent","parasitical","bloodsucking","mutualist","underage","helpless","independence","leechlike","qualified","dependant","conditional","helplessness","reliance","dependency","state","dependance","contingency","subordination","helplessness","dependence","reliance","state","dependance","contingency","subordination","dependant","minion","charge","receiver","recipient","dependant","hooked","strung-out","addicted","drug-addicted","subordinate","subject","pendent","supported","pendant","dependent","qualified","conditional","Crown Colony","geographic region","geographical area","colony","geographic area","geographical region"};
        String[] synonymsForChurn = new String[]{"churn","stir","vessel","butter churn","move","roil","seethe","moil","roll","boil"};
        
        words.put(StringConstants.EMPLOYEE_ID, synonymsForID);
        words.put(StringConstants.EMPLOYEE_NAME, synonymsForName);
        words.put(StringConstants.AGE, synonymsForAge);
        words.put(StringConstants.GENDER, synonymsForGender);
        words.put(StringConstants.MARITAL_STAT, synonymsForMaritalState);
        words.put(StringConstants.HAVING_DEGREE, synonymsForHavingDegree);
        words.put(StringConstants.JOB_ROLE, synonymsForJobRole);
        words.put(StringConstants.TENURE, synonymsForTenure);
        words.put(StringConstants.SALARY, synonymsForSalary);
        words.put(StringConstants.NO_OF_LEAVES, synonymsForNoOfLeaves);
        words.put(StringConstants.DISTANCE, synonymsForDistance);
        words.put(StringConstants.NO_OF_DEPENDENTS, synonymsForDependents);
        words.put(StringConstants.CHURN, synonymsForChurn);
    }
    
    public int getIndex(String word, String[] headersList){      
        //Get Synonym List
        String[] synonyms = words.get(word);
        //Check synonym with header list and return index if found
        for(int i=0;i<synonyms.length;i++){
            for(int j=0;j<headersList.length;j++){
                if(headersList[j].toLowerCase().contains(synonyms[i])){
                    return j;
                }
            }
        }
        return -1;
    }
    
}
