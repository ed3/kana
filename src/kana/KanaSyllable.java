package kana;
import java.util.Random;

public enum KanaSyllable {
	A("\u3042", "\u30A2"),
	I("\u3044", "\u30A4"),
	U("\u3046", "\u30A6"),
	E("\u3048", "\u30A8"),
	O("\u304A", "\u30AA"),

	KA("\u304B", "\u30AB"),
	KI("\u304D", "\u30AD"),
	KU("\u304F", "\u30AF"),
	KE("\u3051", "\u30B1"),
	KO("\u3053", "\u30B3"),
	
	GA("\u304C", "\u30AC"),
	GI("\u304E", "\u30AE"),
	GU("\u3050", "\u30B0"),
	GE("\u3052", "\u30B2"),
	GO("\u3054", "\u30B4"),

	SA("\u3055", "\u30B5"),
	SHI("\u3057", "\u30B7"),
	SU("\u3059", "\u30B9"),
	SE("\u305B", "\u30BB"),
	SO("\u305D", "\u30BD"),
	
	ZA("\u3056", "\u30B6"),
	JI("\u3058", "\u30B8"),
	ZU("\u305A", "\u30BA"),
	ZE("\u305C", "\u30BC"),
	ZO("\u305E", "\u30BE"),

	TA("\u305F", "\u30BF"),
	CHI("\u3061", "\u30C1"),
	TSU("\u3064", "\u30C4"),
	TE("\u3066", "\u30C6"),
	TO("\u3068", "\u30C8"),
	
	DA("\u3060", "\u30C0"),
	DE("\u3067", "\u30C7"),
	DO("\u3069", "\u30C9"),

	NA("\u306A", "\u30CA"),
	NI("\u306B", "\u30CB"),
	NU("\u306C", "\u30CC"),
	NE("\u306D", "\u30CD"),
	NO("\u306E", "\u30CE"),

	HA("\u306F", "\u30CF"),
	HI("\u3072", "\u30D2"),
	FU("\u3075", "\u30D5"),
	HE("\u3078", "\u30D8"),
	HO("\u307B", "\u30DB"),
	
	BA("\u3070", "\u30D0"),
	BI("\u3073", "\u30D3"),
	BU("\u3076", "\u30D6"),
	BE("\u3079", "\u30D9"),
	BO("\u307C", "\u30DC"),

	PA("\u3071", "\u30D1"),
	PI("\u3074", "\u30D4"),
	PU("\u3077", "\u30D7"),
	PE("\u307A", "\u30DA"),
	PO("\u307D", "\u30DD"),
	
	MA("\u307E", "\u30DE"),
	MI("\u307F", "\u30DF"),
	MU("\u3080", "\u30E0"),
	ME("\u3081", "\u30E1"),
	MO("\u3082", "\u30E2"),

	YA("\u3084", "\u30E4"),
	YU("\u3086", "\u30E6"),
	YO("\u3088", "\u30E8"),

	RA("\u3089", "\u30E9"),
	RI("\u308A", "\u30EA"),
	RU("\u308B", "\u30EB"),
	RE("\u308C", "\u30EC"),
	RO("\u308D", "\u30ED"),

	WA("\u308F", "\u30EF"),
	WO("\u3092", "\u30F2"),

	N("\u3093", "\u30F3");

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