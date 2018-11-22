package com.yuansong.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yuansong.global.Global;
import com.yuansong.resource.BaseResource;
import com.yuansong.resource.RdsResource;
import com.yuansong.service.ResourceService;
import com.yuansong.worker.UpdateWxCardNo2;

@Controller
@RequestMapping(value="/")
public class RootController {

	private final Logger logger = Logger.getLogger(RootController.class);
	
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private UpdateWxCardNo2 worker;
	
	@RequestMapping(value="/")
	public ModelAndView defaultPage(Map<String, Object> model){
		logger.debug("跳转到 Current");
		return new ModelAndView("redirect:/FunctionMenu");
	} 
	
	@RequestMapping(value="/PageNotFound")
	public ModelAndView pageNotFound(Map<String, Object> model){
		logger.debug("RootController PageNotFound");

		return Global.getResponseData(404, "page not found");
	}
	
	@RequestMapping(value="/version")
	public ModelAndView getVersion(Map<String, Object> model){
		
		Map<String, String> rData = new HashMap<String, String>();
		rData.put("version", Global.getVersion());
		
		return Global.getResponseData(0, "", rData);
	}
	
	@RequestMapping(value="/FunctionMenu")
	public ModelAndView functionMenu(Map<String, Object> model){
		logger.debug("RootController functionMenu");
		return new ModelAndView("functionMenuPage",model);
	}
	
	@RequestMapping(value="/DataMaintain")
	public ModelAndView dataMaintain(Map<String, Object> model){
		logger.debug("RootController dataMaintain");
		Map<String, String> rData;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			Map<String, List<BaseResource>> data = resourceService.getBaseResourceList();
			for(String key : data.keySet()) {
				for(BaseResource resource : data.get(key)) {
					rData = new HashMap<String, String>();
					rData.put("type", key);
					rData.put("name", resource.getName());
					rData.put("description",resource.getDescription());
					rData.put("id",resource.getId());
					list.add(rData);
				}
			}
			model.put("rlist",list);
			
			List<RdsResource> rdsResourceList = resourceService.getRdsList();
			rData = new HashMap<String, String>();
			for(RdsResource resource : rdsResourceList) {
				rData.put(resource.getId(), resource.getName());
			}
			model.put("rdsList", rData);
			
		} catch (Exception e) {
			return Global.getResponseData(-1, "获取资源列表时发生错误。【" + e.getMessage() + "】");
		}
		
		return new ModelAndView("dataMaintainPage",model);
	}
	
	@RequestMapping(value="/test")
	public ModelAndView test(Map<String, Object> model){
		logger.debug("RootController test");
		
		List<String> list = new ArrayList<String>();
		list.add("896315177945");
		list.add("006963702418");
		list.add("444240213122");
		list.add("804089782356");
		list.add("209744619645");
		list.add("262268143180");
		list.add("742744921408");
		list.add("716450814931");
		list.add("958945855252");
		list.add("687479285220");
		list.add("019108782950");
		list.add("603077422375");
		list.add("792877911612");
		list.add("872473627122");
		list.add("607760770348");
		list.add("551803272482");
		list.add("189993824850");
		list.add("349620341778");
		list.add("201352486834");
		list.add("880440166166");
		list.add("678834802307");
		list.add("658255445427");
		list.add("417800050039");
		list.add("950796601226");
		list.add("034404677698");
		list.add("494968981525");
		list.add("090467997502");
		list.add("302647563686");
		list.add("423278299827");
		list.add("896465246551");
		list.add("165893859202");
		list.add("663746041687");
		list.add("374398865273");
		list.add("613934126064");
		list.add("679161189321");
		list.add("632418343425");
		list.add("157317660223");
		list.add("306783303023");
		list.add("034240916390");
		list.add("792200458100");
		list.add("023633439872");
		list.add("088427032539");
		list.add("008519408666");
		list.add("109984085416");
		list.add("528780178308");
		list.add("417718496812");
		list.add("307572120567");
		list.add("111632405736");
		list.add("577754340655");
		list.add("521261878054");
		list.add("108985292138");
		list.add("426965298130");
		list.add("899081973167");
		list.add("389143687174");
		list.add("834593934103");
		list.add("853319388099");
		list.add("460362879816");
		list.add("037241063776");
		list.add("978732789762");
		list.add("910291638694");
		list.add("472120909389");
		list.add("020374220999");
		list.add("028039013983");
		list.add("246736701749");
		list.add("734145490779");
		list.add("829252889411");
		list.add("037239553158");
		list.add("071821782805");
		list.add("559240090800");
		list.add("225911361857");
		list.add("659925946679");
		list.add("925652603107");
		list.add("884752385010");
		list.add("169882738426");
		list.add("239362777880");
		list.add("726938593754");
		list.add("235079483031");
		list.add("650161621656");
		list.add("153242096348");
		list.add("426752994348");
		list.add("275450572641");
		list.add("032528044151");
		list.add("690424075073");
		list.add("865682891143");
		list.add("603305789254");
		list.add("328748481271");
		list.add("082493442535");
		list.add("256911632610");
		list.add("016316009047");
		list.add("065951841889");
		list.add("467161647975");
		list.add("124990881321");
		list.add("965541209381");
		list.add("079283936378");
		list.add("519172931073");
		list.add("836721202881");
		list.add("820786506661");
		list.add("244375054092");
		list.add("830112017627");
		list.add("605943464341");
		list.add("498615419080");
		list.add("422122496602");
		list.add("744428610088");
		list.add("586754555113");
		list.add("662355338489");
		list.add("431829816592");
		list.add("368052847290");
		list.add("085970426409");
		list.add("358547145806");
		list.add("096720420309");
		list.add("799521424970");
		list.add("925331040998");
		list.add("060817548332");
		list.add("537076119132");
		list.add("806571163479");
		list.add("223677239416");
		list.add("718197685197");
		list.add("199910123264");
		list.add("738164415943");
		list.add("459344041166");
		list.add("529814082998");
		list.add("551947395498");
		list.add("428428644746");
		list.add("239050294782");
		list.add("154738519455");
		list.add("797159606561");
		list.add("246767695915");
		list.add("186004478812");
		list.add("134209607390");
		list.add("651241451135");
		list.add("090508860393");
		list.add("370993662641");
		list.add("130337128495");
		list.add("219965969732");
		list.add("423941885337");
		list.add("838082133959");
		list.add("893255284819");
		list.add("252548667770");
		list.add("259079380483");
		list.add("241992393910");
		list.add("312802574667");
		list.add("042780048065");
		list.add("823523110136");
		list.add("831475259354");
		list.add("648336398079");
		list.add("597645868658");
		list.add("954767997066");
		list.add("783876072533");
		list.add("221021285572");
		list.add("562480497744");
		list.add("863341832693");
		list.add("170086075904");
		list.add("144422402368");
		list.add("317236534855");
		list.add("285669197127");
		list.add("666662578534");
		list.add("000153660456");
		list.add("327027646592");
		list.add("463605745939");
		list.add("829490082005");
		list.add("614656477149");
		list.add("352689367060");
		list.add("972900114054");
		list.add("758748310719");
		list.add("479499064454");
		list.add("183455213487");
		list.add("805029190289");
		list.add("420075511847");
		list.add("924225083198");
		list.add("110465065155");
		list.add("765068820371");
		list.add("414675087828");
		list.add("923173947033");
		list.add("770850749217");
		list.add("568168958023");
		list.add("903660082541");
		list.add("526570355063");
		list.add("567673976279");
		list.add("235594918687");
		list.add("516862452473");
		list.add("491620164754");
		list.add("993056681875");
		list.add("991469142710");
		list.add("467007571029");
		list.add("920601456016");
		list.add("577076907548");
		list.add("814244343607");
		list.add("588017957660");
		list.add("637812894220");
		list.add("015007965163");
		list.add("319298301989");
		list.add("812138542028");
		list.add("819267590298");
		list.add("721420956754");
		list.add("907163091242");
		list.add("840717163350");
		list.add("210956404363");
		list.add("708461529135");
		list.add("064552968596");
		list.add("206592387759");
		list.add("509029735973");
		list.add("509735183185");
		list.add("822038151268");
		list.add("727321848139");
		list.add("965539061661");
		list.add("418538659715");
		list.add("806275426515");
		list.add("181298398204");
		list.add("391634684872");
		list.add("557758558954");
		list.add("348703627593");
		list.add("586819902909");
		list.add("377518337046");
		list.add("666600213439");
		list.add("668133608175");
		list.add("089691475824");
		list.add("247110769614");
		list.add("148253865771");
		list.add("199230108189");
		list.add("871313037944");
		list.add("192276859681");
		list.add("705336639075");
		list.add("422922528121");
		list.add("120283506153");
		list.add("941716232217");
		list.add("503120646093");
		list.add("622444991633");
		list.add("572930527380");
		list.add("261056255924");
		list.add("982433163163");
		list.add("014962206685");
		list.add("310306033687");
		list.add("829399285365");
		list.add("038220944931");
		list.add("240063388292");
		list.add("495165883147");
		list.add("031408439187");
		list.add("935221272242");
		list.add("779781054672");
		list.add("365260886008");
		list.add("231135033652");
		list.add("183434959934");
		list.add("951238269972");
		list.add("178582641447");
		list.add("288147948450");
		list.add("339223778279");
		list.add("371873601643");
		list.add("630886651055");
		list.add("044921256992");
		list.add("316815047132");
		list.add("249910783407");
		list.add("991381287843");
		list.add("281569397197");
		list.add("035777038555");
		list.add("700011309674");
		list.add("335534467209");
		list.add("416048857241");
		list.add("174327988842");
		list.add("795831858007");
		list.add("632419351285");
		list.add("125059420015");
		list.add("302750525853");
		list.add("269594313228");
		list.add("557420370957");
		list.add("835249640991");
		list.add("454096537193");
		list.add("767706776793");
		list.add("436508649088");
		list.add("457855936842");
		list.add("351484372519");
		list.add("649287475017");
		list.add("363210423467");
		list.add("302690378474");
		list.add("325198177826");
		list.add("535634778860");
		list.add("178053322974");
		list.add("291006903838");
		list.add("250484651059");
		list.add("410282945118");
		list.add("842337435443");
		list.add("962588989287");
		list.add("318121977759");
		list.add("596511896338");
		list.add("629738020403");
		list.add("338429280430");
		list.add("035262772709");
		list.add("495643558027");
		list.add("414914410119");
		list.add("430796215727");
		list.add("567240041786");
		list.add("317060773637");
		list.add("245196657289");
		list.add("038977225293");
		list.add("265102291604");
		list.add("693703836342");
		list.add("210806421961");
		list.add("363813332654");
		list.add("010131392264");
		list.add("658993206564");
		list.add("991574974793");
		list.add("356361226439");
		list.add("579268662326");
		list.add("480152222122");
		list.add("198989818743");
		list.add("659629107588");
		list.add("256075983265");
		list.add("843214137602");
		list.add("664622020428");
		list.add("351271515604");
		list.add("611260759636");
		list.add("306380717439");
		list.add("926412722113");
		list.add("620198551091");
		list.add("236026284630");
		list.add("189612747242");
		list.add("066956699391");
		list.add("450804382793");
		list.add("703995557437");
		list.add("847396032925");
		list.add("490522986669");
		list.add("502789473638");
		list.add("443438528451");
		list.add("054889636442");
		list.add("312714301768");
		list.add("773507505712");
		list.add("651100005795");
		list.add("681485487227");
		list.add("853301511822");
		list.add("468252348476");
		list.add("575613925585");
		list.add("334292131289");
		list.add("962831977424");
		list.add("003168111077");
		list.add("564042611090");
		list.add("085029199341");
		list.add("993431328611");
		list.add("975403025796");
		list.add("565464862544");
		list.add("581261570174");
		list.add("393693621343");
		list.add("593425697862");
		list.add("656020000544");
		list.add("545649274652");
		list.add("236807070568");
		list.add("893688407454");
		list.add("906602504788");
		list.add("371863260003");
		list.add("833760116428");
		list.add("943945842108");
		list.add("836892593458");
		list.add("687447597929");
		list.add("321844265053");
		list.add("275721741151");
		list.add("529005405525");
		list.add("572741831526");
		list.add("214421767696");
		list.add("147595979378");
		list.add("841657917642");
		list.add("924267291266");
		list.add("099950056567");
		list.add("829842795022");
		list.add("354116893533");
		list.add("607978918431");
		list.add("740931666503");
		list.add("381666024492");
		list.add("433220666344");
		list.add("704267761113");
		list.add("930588211449");
		list.add("980041885728");
		list.add("119841363453");
		list.add("161718152987");
		list.add("201203125413");
		list.add("509522789733");
		list.add("804631028291");
		list.add("693953125692");
		list.add("924094476625");
		list.add("245820044443");
		list.add("732748630138");
		list.add("876034372482");
		list.add("112992358641");
		list.add("134395569235");
		list.add("330963545652");
		list.add("649417691670");
		list.add("433288356397");
		list.add("540370641064");
		list.add("253016607702");
		list.add("483154881484");
		list.add("135496337097");
		list.add("829669179645");
		list.add("894499898178");
		list.add("433911720025");
		list.add("118477202064");
		list.add("202600354067");
		list.add("543669218033");
		list.add("644871237180");
		list.add("086919816128");
		list.add("272048203716");
		list.add("676404592767");
		list.add("703566964492");
		list.add("515598083893");
		list.add("238795303832");
		list.add("099892160940");
		list.add("622859994282");
		list.add("942076768177");
		list.add("732157460060");
		list.add("152504079655");
		list.add("479460660125");
		list.add("294807893181");
		list.add("428446863289");
		list.add("252061137790");
		list.add("870277378595");
		list.add("812196144458");
		list.add("450612218005");
		list.add("637168183151");
		list.add("672947573011");
		list.add("281079597020");
		list.add("068975173847");
		list.add("157588802153");
		list.add("361446727752");
		list.add("035443110087");
		list.add("034999989406");
		list.add("342962332141");
		list.add("776250607375");
		list.add("176317289937");
		list.add("912247527087");
		list.add("659911321075");
		list.add("231406468903");
		list.add("205297521402");
		list.add("889088998711");
		list.add("600128064265");
		list.add("750845092900");
		list.add("408585758888");
		list.add("258433508858");
		list.add("780154100656");
		list.add("033525820430");
		list.add("466286421582");
		list.add("099888964490");
		list.add("675094996254");
		list.add("851760661164");
		list.add("119940857343");
		list.add("600013331441");
		list.add("105474150788");
		list.add("375986928935");
		list.add("415325577483");
		list.add("330890680820");
		list.add("996708583845");
		list.add("894420654804");
		list.add("626513650357");
		list.add("753534882742");
		list.add("946612152074");
		list.add("933617521997");
		list.add("956058536094");
		list.add("290445804223");
		list.add("718015681945");
		list.add("405525764510");
		list.add("352426591017");
		list.add("993716556416");
		list.add("260674980258");
		list.add("280081634730");
		list.add("082818299302");
		list.add("907694153198");
		list.add("270883994070");
		list.add("343353824376");
		list.add("231835280258");


		

		Map<String,String> rData = new HashMap<String,String>();
		
		String result;
		int i=1;
		
		for(String rcode : list) {
			try {
				result = worker.update(rcode);
			} catch (Exception e) {
				e.printStackTrace();
				result = e.getMessage();
			}
			rData.put(rcode, result);
			
			logger.debug(String.valueOf(i) + " - " + rcode + " - " + result);
			i=i+1;
		}
		
		return Global.getResponseData(0, "",rData);
		
//		Map<String, Object> data = new HashMap<String, Object>();
//        data.put("errcode", 0);
//        data.put("errmsg", "");
//        data.put("data", testService.test());
//		
//		model.put("info",mGson.toJson(data));
////        model.put("info", testService.test());
	}
	
//	@RequestMapping(value="/testPage")
//	public ModelAndView testPage(Map<String, Object> model){
//		logger.info("RootController testPage");
//		model.put("info", "testPage");
//
//		return new ModelAndView("testPage",model);
//	}
//	
//	@RequestMapping(value="/testPageOne")
//	public ModelAndView testPageOne(Map<String, Object> model){
//		logger.info("RootController testPageOne");
//		model.put("info", "testPageOne");
//
//		return new ModelAndView("testPage",model);
//	}
//	
//	@RequestMapping(value="/testErrorPage")
//	public ModelAndView testErrorPage(Map<String, Object> model){
//		logger.info("RootController testErrorPage");
//		model.put("info", "testPageOne");
//
//		throw new RuntimeException("sfesf");
////		return new ModelAndView("testPage",model);
//	}
	
}
