package com.api.tq;
/**
 * @enum: Profession
 * @description: 
 * @author: L.zhen
 * @date: 2021/2/17 10:48
 */
public enum Profession {

	Soothsayer  (0b000000001, "预言家",		new Mastery[]{Mastery.SPIRIT,  Mastery.NATURE}),
	Warlock     (0b000000010, "术士",		new Mastery[]{Mastery.SPIRIT,  Mastery.ROGUE}),
	Illusionist (0b000000011, "幻术师",		new Mastery[]{Mastery.NATURE,  Mastery.ROGUE}),
	Bonecharmer (0b000000100, "死灵法师",	new Mastery[]{Mastery.SPIRIT,  Mastery.HUNTING}),
	Ranger      (0b000000101, "巡林客",		new Mastery[]{Mastery.NATURE,  Mastery.HUNTING}),
	Brigand     (0b000000110, "强盗",		new Mastery[]{Mastery.ROGUE,   Mastery.HUNTING}),
	Oracle      (0b000001000, "神使",		new Mastery[]{Mastery.SPIRIT,  Mastery.STORM}),
	Druid       (0b000001001, "德鲁伊",		new Mastery[]{Mastery.NATURE,  Mastery.STORM}),
	Sorcerer    (0b000001010, "巫师",		new Mastery[]{Mastery.ROGUE,   Mastery.STORM}),
	Sage        (0b000001100, "贤者",		new Mastery[]{Mastery.HUNTING, Mastery.STORM}),
	Conjurer    (0b000010000, "咒术师",		new Mastery[]{Mastery.SPIRIT,  Mastery.EARTH}),
	Summoner    (0b000010001, "召唤者",		new Mastery[]{Mastery.NATURE,  Mastery.EARTH}),
	Magician    (0b000010010, "魔术师",		new Mastery[]{Mastery.ROGUE,   Mastery.EARTH}),
	Avenger     (0b000010100, "复仇者",		new Mastery[]{Mastery.HUNTING, Mastery.EARTH}),
	Elementalist(0b000011000, "元素师",		new Mastery[]{Mastery.STORM,   Mastery.EARTH}),
	Spellbinder (0b000100000, "吟咒者",		new Mastery[]{Mastery.SPIRIT,  Mastery.DEFENSE}),
	Guardian    (0b000100001, "守护者",		new Mastery[]{Mastery.NATURE,  Mastery.DEFENSE}),
	Corsair     (0b000100010, "海盗",		new Mastery[]{Mastery.ROGUE,   Mastery.DEFENSE}),
	Warden      (0b000100100, "典狱官",		new Mastery[]{Mastery.HUNTING, Mastery.DEFENSE}),
	Paladin     (0b000101000, "圣武士",		new Mastery[]{Mastery.STORM,   Mastery.DEFENSE}),
	Juggernaut  (0b000110000, "主宰者",		new Mastery[]{Mastery.EARTH,   Mastery.DEFENSE}),
	Spellbreaker(0b001000000, "破法者",		new Mastery[]{Mastery.SPIRIT,  Mastery.WARFARE}),
	Champion    (0b001000001, "斗士",		new Mastery[]{Mastery.NATURE,  Mastery.WARFARE}),
	Assassin    (0b001000010, "刺客",		new Mastery[]{Mastery.ROGUE,   Mastery.WARFARE}),
	Slayer      (0b001000100, "屠宰者",		new Mastery[]{Mastery.HUNTING, Mastery.WARFARE}),
	Thane       (0b001001000, "领主",		new Mastery[]{Mastery.STORM,   Mastery.WARFARE}),
	Battlemage  (0b001010000, "战斗法师",	new Mastery[]{Mastery.EARTH,   Mastery.WARFARE}),
	Conquerer   (0b001100000, "征服者",		new Mastery[]{Mastery.DEFENSE, Mastery.WARFARE}),
	Diviner     (0b010000000, "占卜师",		new Mastery[]{Mastery.SPIRIT,  Mastery.DREAM}),
	Ritualist   (0b010000001, "祭司",		new Mastery[]{Mastery.NATURE,  Mastery.DREAM}),
	Dreamkiller (0b010000010, "毁梦者",		new Mastery[]{Mastery.ROGUE,   Mastery.DREAM}),
	Haruspex    (0b010000100, "罗马占卜师",	new Mastery[]{Mastery.HUNTING, Mastery.DREAM}),
	Prophet     (0b010001000, "先知",		new Mastery[]{Mastery.STORM,   Mastery.DREAM}),
	Evoker      (0b010010000, "召魂者",		new Mastery[]{Mastery.EARTH,   Mastery.DREAM}),
	Templar     (0b010100000, "圣殿骑士",	new Mastery[]{Mastery.DEFENSE, Mastery.DREAM}),
	Harbinger   (0b011000000, "先锋",		new Mastery[]{Mastery.WARFARE, Mastery.DREAM}),
	Shaman      (0b100000000, "萨满",		new Mastery[]{Mastery.SPIRIT,  Mastery.RUNE}),
	Skinchanger (0b100000001, "易形者",		new Mastery[]{Mastery.NATURE,  Mastery.RUNE}),
	Trickster   (0b100000010, "魔法师",		new Mastery[]{Mastery.ROGUE,   Mastery.RUNE}),
	Dragonhunter(0b100000100, "猎龙者",		new Mastery[]{Mastery.HUNTING, Mastery.RUNE}),
	Thunderer   (0b100001000, "雷吼者",		new Mastery[]{Mastery.STORM,   Mastery.RUNE}),
	Stonespeaker(0b100010000, "石语者",		new Mastery[]{Mastery.EARTH,   Mastery.RUNE}),
	Runesmith   (0b100100000, "符文铁匠",	new Mastery[]{Mastery.DEFENSE, Mastery.RUNE}),
	Berserker   (0b101000000, "狂战士",		new Mastery[]{Mastery.WARFARE, Mastery.RUNE}),
	Seidrworker (0b110000000, "赛德魔法工",	new Mastery[]{Mastery.DREAM,   Mastery.RUNE}),
	;

	private int code;
	private String name;
	private Mastery[] masteries;
	
	Profession(int code, String name, Mastery[] masteries) {
		this.code = code;
		this.name = name;
		this.masteries = masteries;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Mastery[] getMasteries() {
		return masteries;
	}
	
	public void setMasteries(Mastery[] masteries) {
		this.masteries = masteries;
	}
	
	public static Profession get(int code) {
		for (Profession p : Profession.values()) {
			if (p.code == code) {
				return p;
			}
		}
		return null;
	}
}
