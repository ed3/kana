package kana;
import java.util.Random;

public enum KanaSyllable {
	A("あ", "ア"),
	I("い", "イ"),
	U("う", "ウ"),
	E("え", "エ"),
	O("お", "オ"),

	KA("か", "カ"),
	KI("き", "キ"),
	KU("く", "ク"),
	KE("け", "ケ"),
	KO("こ", "コ"),
	
	GA("が", "ガ"),
	GI("ぎ", "ギ"),
	GU("ぐ", "グ"),
	GE("げ", "ゲ"),
	GO("ご", "ゴ"),

	SA("さ", "サ"),
	SHI("し", "シ"),
	SU("す", "ス"),
	SE("せ", "セ"),
	SO("そ", "ソ"),
	
	ZA("ざ", "ザ"),
	JI("じ", "ジ"),
	ZU("ず", "ズ"),
	ZE("ぜ", "ゼ"),
	ZO("ぞ", "ゾ"),

	TA("た", "タ"),
	CHI("ち", "チ"),
	TSU("つ", "ツ"),
	TE("て", "テ"),
	TO("と", "ト"),
	
	DA("だ", "ダ"),
	DE("で", "デ"),
	DO("ど", "ド"),

	NA("な", "ナ"),
	NI("に", "ニ"),
	NU("ぬ", "ヌ"),
	NE("ね", "ネ"),
	NO("の", "ノ"),

	HA("は", "ハ"),
	HI("ひ", "ヒ"),
	FU("ふ", "フ"),
	HE("へ", "ヘ"),
	HO("ほ", "ホ"),
	
	BA("ば", "バ"),
	BI("び", "ビ"),
	BU("ぶ", "ブ"),
	BE("べ", "ベ"),
	BO("ぼ", "ボ"),

	PA("ぱ", "パ"),
	PI("ぴ", "ピ"),
	PU("ぷ", "プ"),
	PE("ぺ", "ペ"),
	PO("ぽ", "ポ"),
	
	MA("ま", "マ"),
	MI("み", "ミ"),
	MU("む", "ム"),
	ME("め", "メ"),
	MO("も", "モ"),

	YA("や", "ヤ"),
	YU("ゆ", "ユ"),
	YO("よ", "ヨ"),

	RA("ら", "ラ"),
	RI("り", "リ"),
	RU("る", "ル"),
	RE("れ", "レ"),
	RO("ろ", "ロ"),

	WA("わ", "ワ"),
	WO("を", "ヲ"),

	N("ん", "ン");

	private final String hiragana, katakana;

	private KanaSyllable(String hiragana, String katakana) {
		this.hiragana = hiragana;
		this.katakana = katakana;
	}
	
	public final KanaSyllable random() {
		Random random = new Random();
		KanaSyllable[] kanas = KanaSyllable.values();
		return kanas[random.nextInt(kanas.length)];
	}

	public String getType(int cType) {
		switch (cType) {
		case 1:
			return hiragana;
		case 2:
			return katakana;
		default:
			return getRomaji();
		}
	}
	public String getHiragana() {
		return hiragana;
	}
	public String getKatakana() {
		return katakana;
	}
	public String getRomaji() {
		return this.toString().toLowerCase();
	}
}
