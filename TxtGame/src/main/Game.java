package main;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import itemsPackage.Super_Item;
import weaponPackage.Super_Weapon;

//import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion.Setting;

public class Game {
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel,moneyPanel,inventoryPanel,inventoryButtonPanel,playerInfoPanel,positionPanel
	,weaponSelectorButtonPanel,weaponSelectorPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber,hpLabelNumber1, weaponLabel, weaponLabelName,moneyValue,weaponLabelName1,moneyText,positionPanelText,
	moneyValue1,playerLevelLabel,playerLevelText;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 20);
	JButton startButton, choice1, choice2, choice3, choice4,inventoryButton,itemButton1,itemButton2,itemButton3,itemButton4,itemButton5,weaponSelector,
	weaponButton2,weaponButton1,weaponButton3,weaponButton4;
	JTextArea mainTextArea,playerInfoText;
	int playerHP, monsterHP, silverRing,money,monsterInt, monsterDamage,monsterHealth,inventoryAmount;
	String weapon,weapon1, position, item,inventoryStatus,weaponOpen;
	String monster,direction,selectedWeapon;
	boolean fireball,gotFreeBread;
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	InventoryHandler ihandler = new InventoryHandler();
	//WeaponHandler wHandler = new WeaponHandler();
	public double playerLevel;
	int leadChoice, healspell = 30, weaponDamage, itemDropper,purchase,weaponSelected,selectedWeaponDamage;
	
	
	
	String[] dropItems = new String[3];
	Super_Item[] playerItem = new Super_Item[5];
	Super_Weapon[] playerWeapon = new Super_Weapon[5];
	
	itemsPackage.Potion_Healing HealingPotion = new itemsPackage.Potion_Healing();
	itemsPackage.Food_Bread Bread = new itemsPackage.Food_Bread();
	itemsPackage.Item_Empty Empty = new itemsPackage.Item_Empty();
	itemsPackage.Wonderer_LeftArm Arm = new itemsPackage.Wonderer_LeftArm();
	itemsPackage.Item_DragonsTooth DragonsTooth = new itemsPackage.Item_DragonsTooth();
	monsterPackage.Monster_Dragon Dragon = new monsterPackage.Monster_Dragon();
	monsterPackage.Monster_Spider Spider = new monsterPackage.Monster_Spider();
	monsterPackage.Monster_Troll Troll = new monsterPackage.Monster_Troll();
	weaponPackage.Iron_Sword Iron_Sword = new weaponPackage.Iron_Sword();
	weaponPackage.Trolls_Mallet Mallet = new weaponPackage.Trolls_Mallet();
	weaponPackage.Empty_Weapon EmptyWeapon = new weaponPackage.Empty_Weapon();
	weaponPackage.Silver_Dagger Silver_Dagger = new weaponPackage.Silver_Dagger();
	weaponPackage.AR15 AR15 = new weaponPackage.AR15();
	
	
	 String returnArm;
	 int armChecked;
	
	public static void main(String[] args) {

		new Game();
	}
	public Game(){
		//iconImage img = new iconImage("C:\Users\wolfnv\Downloads\IMG_20170518_122148_599.jpg");
		//URL url = getClass().getResource("Downloads/IMG_20170518_122148_599.jpg");
		//ImageIcon imgicon = new ImageIcon();
		window = new JFrame();
		window.setIconImage(new ImageIcon(getClass().getResource("original.jpg")).getImage());
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		window.setResizable(false);
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("RIVERWOOD");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);	
		con.add(titleNamePanel);
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		con.add(startButtonPanel);
		
		
	}
	/*private void setIcon(Image image) {
		setIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(image)));
		
	}*/
	public void createGameScreen(){
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 75, 600, 200);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 300, 350, 200);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		con.add(choiceButtonPanel);
		
		inventoryButtonPanel = new JPanel();
		inventoryButtonPanel.setBounds(250,500,350,200);
		inventoryButtonPanel.setLayout(new GridLayout(4,1));
		inventoryButtonPanel.setBackground(Color.black);
		con.add(inventoryButtonPanel);
		
		playerInfoPanel = new JPanel();
		playerInfoPanel.setBounds(100, 75, 600, 200);
		playerInfoPanel.setBackground(Color.black);
		playerInfoPanel.setLayout(new GridLayout(1,4));
		playerInfoPanel.setVisible(false);
		con.add(playerInfoPanel);
		
		playerInfoText = new JTextArea("");
		playerInfoText.setBounds(100, 100, 600, 250);
		playerInfoText.setBackground(Color.black);
		playerInfoText.setForeground(Color.white);
		playerInfoText.setFont(normalFont);
		playerInfoText.setLineWrap(true);
		playerInfoPanel.add(playerInfoText);
		
		
		moneyText= new JLabel();
		moneyText.setFont(normalFont);
		moneyText.setForeground(Color.white);
		moneyText.setText("Money:");
		playerInfoPanel.add(moneyText);
		
		moneyValue1 = new JLabel();
		moneyValue1.setFont(normalFont);
		moneyValue1.setForeground(Color.white);
		playerInfoPanel.add(moneyValue1);
		
		playerLevelLabel = new JLabel("Level:");
		playerLevelLabel.setFont(normalFont);
		playerLevelLabel.setForeground(Color.white);
		playerInfoPanel.add(playerLevelLabel);
		
		playerLevelText = new JLabel();
		playerLevelText.setFont(normalFont);
		playerLevelText.setForeground(Color.white);
		playerInfoPanel.add(playerLevelText);
		
		inventoryButton = new JButton("[ Inventory ]");
		inventoryButton.setBackground(Color.gray);
		inventoryButton.setForeground(Color.black);
		inventoryButton.setFont(normalFont);
		inventoryButton.setFocusPainted(false);
		inventoryButton.addActionListener(ihandler);
		inventoryButton.setActionCommand("Inventory");
		inventoryButtonPanel.add(inventoryButton);
		
		
		inventoryPanel = new JPanel();
		inventoryPanel.setBounds(250, 300, 350, 200);
		inventoryPanel.setBackground(Color.black);
		inventoryPanel.setLayout(new GridLayout(5,1));
		
		itemButton1 = new JButton();
		itemButton1.setBackground(Color.black);
		itemButton1.setForeground(Color.white);
		itemButton1.setFont(normalFont);
		itemButton1.setFocusPainted(false);
		itemButton1.addActionListener(ihandler);
		itemButton1.setActionCommand("item1");
		
		itemButton2 = new JButton();
		itemButton2.setBackground(Color.black);
		itemButton2.setForeground(Color.white);
		itemButton2.setFont(normalFont);
		itemButton2.setFocusPainted(false);
		itemButton2.addActionListener(ihandler);
		itemButton2.setActionCommand("item2");
		
		itemButton3 = new JButton();
		itemButton3.setBackground(Color.black);
		itemButton3.setForeground(Color.white);
		itemButton3.setFont(normalFont);
		itemButton3.setFocusPainted(false);
		itemButton3.addActionListener(ihandler);
		itemButton3.setActionCommand("item3");
		
		itemButton4 = new JButton();
		itemButton4.setBackground(Color.black);
		itemButton4.setForeground(Color.white);
		itemButton4.setFont(normalFont);
		itemButton4.setFocusPainted(false);
		itemButton4.addActionListener(ihandler);
		itemButton4.setActionCommand("item4");
		
		itemButton5 = new JButton();
		itemButton5.setBackground(Color.black);
		itemButton5.setForeground(Color.white);
		itemButton5.setFont(normalFont);
		itemButton5.setFocusPainted(false);
		itemButton5.addActionListener(ihandler);
		itemButton5.setActionCommand("item5");
		
		inventoryPanel.add(itemButton1);
		inventoryPanel.add(itemButton2);
		inventoryPanel.add(itemButton3);
		inventoryPanel.add(itemButton4);
		inventoryPanel.add(itemButton5);
		
		con.add(inventoryPanel);
		inventoryPanel.setVisible(false);
		
		playerPanel = new JPanel();
		
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		con.add(playerPanel);
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		/*weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);*/
		
		
		weaponSelector = new JButton("None");
		weaponSelector.setBackground(Color.black);
		weaponSelector.setForeground(Color.white);
		weaponSelector.setFont(normalFont);
		weaponSelector.setFocusPainted(false);
		weaponSelector.addActionListener(ihandler);
		weaponSelector.setActionCommand("weaponSelector");
		playerPanel.add(weaponSelector);
		
		weaponSelectorPanel = new JPanel();
		weaponSelectorPanel.setBounds(450, 75, 350, 200);
		weaponSelectorPanel.setBackground(Color.black);
		weaponSelectorPanel.setLayout(new GridLayout(4,1));
		con.add(weaponSelectorPanel);
		
		
		
		weaponButton1 = new JButton();
		weaponButton1.setBackground(Color.black);
		weaponButton1.setForeground(Color.white);
		weaponButton1.setFont(normalFont);
		weaponButton1.setFocusPainted(false);
		weaponButton1.addActionListener(ihandler);
		weaponButton1.setActionCommand("weapon1");
		
		weaponButton2 = new JButton();
		weaponButton2.setBackground(Color.black);
		weaponButton2.setForeground(Color.white);
		weaponButton2.setFont(normalFont);
		weaponButton2.setFocusPainted(false);
		weaponButton2.addActionListener(ihandler);
		weaponButton2.setActionCommand("weapon2");
		
		weaponButton3 = new JButton();
		weaponButton3.setBackground(Color.black);
		weaponButton3.setForeground(Color.white);
		weaponButton3.setFont(normalFont);
		weaponButton3.setFocusPainted(false);
		weaponButton3.addActionListener(ihandler);
		weaponButton3.setActionCommand("weapon3");
		
		weaponButton4 = new JButton();
		weaponButton4.setBackground(Color.black);
		weaponButton4.setForeground(Color.white);
		weaponButton4.setFont(normalFont);
		weaponButton4.setFocusPainted(false);
		weaponButton4.addActionListener(ihandler);
		weaponButton4.setActionCommand("weapon4");
		

		weaponSelectorPanel.add(weaponButton1);
		weaponSelectorPanel.add(weaponButton2);
		weaponSelectorPanel.add(weaponButton3);
		weaponSelectorPanel.add(weaponButton4);
		
		weaponSelectorPanel.setVisible(false);
		weaponOpen = "Close";
		
		moneyPanel = new JPanel();
		moneyPanel.setBounds(10, 500, 100, 50);
		moneyPanel.setBackground(Color.black);
		moneyPanel.setForeground(Color.black);
		con.add(moneyPanel);
		moneyPanel.setVisible(true);
		moneyValue = new JLabel();
		moneyValue.setFont(normalFont);
		moneyValue.setForeground(Color.white);
		moneyPanel.add(moneyValue);
		
		
		positionPanel = new JPanel();
		positionPanel.setBounds(600, 500, 200, 50);
		positionPanel.setBackground(Color.black);
		positionPanel.setForeground(Color.black);
		con.add(positionPanel);
		
		positionPanelText = new JLabel();
		positionPanelText.setFont(normalFont);
		positionPanelText.setForeground(Color.white);
		positionPanel.add(positionPanelText);
		positionPanel.setVisible(true);
		playerSetup();

	}
	public void weaponGen(){
		int weaponPointer = new java.util.Random().nextInt(2);
		if (weaponPointer <= 1){
			weapon = Iron_Sword.name;
			//weaponLabelName.setText(weapon);
			weaponSelector.setText(weapon);
			weaponDamage = Iron_Sword.weaponDamage;
			
		}else {
			weapon = AR15.name;
			//weaponLabelName.setText(weapon);
			weaponSelector.setText(weapon);
			weaponDamage = AR15.weaponDamage;
		}

	}
	public void monsterGen() {

		monsterInt = new java.util.Random().nextInt(75);
		if (monsterInt <=25) {
			monster = Dragon.monsterName;
			monsterDamage = Dragon.monsterDamage;
			monsterHP = Dragon.monsterHealth;
			dropItems[0]= "Dragons Tooth";
			dropItems[1]= "Gold";
			dropItems[2]= "Xp";
		
		}else if (monsterInt >25 && monsterInt <=50 ) {
			monster = Spider.monsterName;
			monsterDamage = Spider.monsterDamage;
			monsterHP = Spider.monsterHealth;
			dropItems[0]= "Silk";
			dropItems[1]= "Gold";
			dropItems[2]= "Xp";
			
		}else if (monsterInt >50 && monsterInt <=75 ) {
			monster = Troll.monsterName;
			monsterDamage = Troll.monsterDamage;
			monsterHP = Troll.monsterHealth;
			dropItems[0]= "Trolls Mallet";
			dropItems[1]= "Gold";
			dropItems[2]= "Xp";
		}
	}
	public void inventory() {
		
	}
	public void itemDrop() {
		itemDropper = new java.util.Random().nextInt(2);
		if(itemDropper ==0 ) {
			item = dropItems[0];
		}else if(itemDropper ==1) {
			item = dropItems[1];
		}else if(itemDropper ==2) {
			item = dropItems[2];
		}
		
		int slotNumber=0;
		while(playerItem[slotNumber] != Empty && slotNumber<4) {
		slotNumber++;
	}
		if(playerItem[slotNumber]==Empty) {
			moneyValueUpdater();
				//playerItem[slotNumber] = dropItems[itemDropper] ;
				purchase = 1;
				chase();
			
		}
		
	}
	public void playerSetup(){
		inventoryStatus = "Close";
		playerLevel=1;
		playerHP = 100;
		money = 100;
		monsterHP = (int) (playerLevel / .5);
		
		weapon = weapon1;
		//weaponLabelName.setText(weapon + "");
		//weaponLabelName1.setText(weapon+"");
		hpLabelNumber.setText("" + playerHP);
		//hpLabelNumber1.setText(playerHP+"");
		moneyValue.setText(money + " Gold");
		moneyValue1.setText(money + "");
		playerLevelText.setText(playerLevel+"");
		
		selectedWeapon = "None";
		
		playerItem[0] = Empty;
		playerItem[1] = Empty;
		playerItem[2] = Empty;
		playerItem[3] = Empty;
		playerItem[4] = Empty;
		
		playerWeapon[0] = EmptyWeapon;
		playerWeapon[1] = EmptyWeapon;
		playerWeapon[2] = EmptyWeapon;
		playerWeapon[3] = EmptyWeapon;
		
		RiverwoodGate();
	}
	public void RiverwoodGate(){
		position = "RiverwoodGate";
		positionPanelText.setText(position);
		mainTextArea.setText("You are at the gate of Riverwood. \nA guard is standing in front of you. \n\nWhat do you do?");		
		choice1.setText("Talk to the guard");
		choice2.setText("Attack the guard");
		choice3.setText("Leave");
		choice4.setText("");
	}
	public void talkGuard(){
		position = "talkGuard";
		positionPanelText.setText(position);
		if(selectedWeapon == "None") {
			mainTextArea.setText("Guard: Hello stranger. I have never seen your face. \nBut you seem like good people.");
			choice1.setText(">");
			choice2.setText("Enter Riverwood");
			choice3.setText("");
			choice4.setText("");
		}else {
			mainTextArea.setText("Guard: Stranger! stop muah haha ");
			choice1.setText(">");
			choice2.setText("Enter Riverwood");
			choice3.setText("");
			choice4.setText("");
		}
		
	}
	public void RiverWood() {
		position = "RiverWood";
		positionPanelText.setText(position);
		mainTextArea.setText("You are in Riverwood");
		choice1.setText("Leave");
		choice2.setText("Amora's inn");
		choice3.setText("RiverSide Tavern");
		choice4.setText("Chase's Supply");
	}
	public void buyBread() {
		position = "buyBread";
		positionPanelText.setText(position);
		int slotNumber=0;
		while(playerItem[slotNumber] != Empty && slotNumber<4) {
			slotNumber++;
		}
		if(playerItem[slotNumber]==Empty && money>= Bread.buyingPrice) {
			money = money - Bread.buyingPrice;
			moneyValueUpdater();
			playerItem[slotNumber] = Bread ;
			purchase = 1;
			Amora();
		}else if((playerItem[slotNumber] != Empty) || (money< Bread.buyingPrice)) {
			if(money< Bread.buyingPrice){
				purchase = 0;
				mainTextArea.setText("Amora: Hmm...Seems you havent the Gold for It...");
			}else if(playerItem[slotNumber] != Empty) {
				purchase = 0;
				mainTextArea.setText("Amora: Hmm...Seems you havent the space for It...");
			}
				choice1.setText("<");
				choice2.setText("");
				choice3.setText("");
				choice4.setText("");
		}
		
	}
	public void Amora() {
		position = "AmoraInn";
		positionPanelText.setText(position);
		if(purchase == 0) {
			mainTextArea.setText("Amora: Welcome! What are you looking for?");
			choice1.setText("Leave");
			choice2.setText("Rent Room (10 Gold)");
			choice3.setText("Any Leads?");
			choice4.setText("Food");
		}else {
			mainTextArea.setText("Amora: Will that be all?\n You recieved Bread");
			choice1.setText("Leave");
			choice2.setText("Rent Room (10 Gold)");
			choice3.setText("Any Leads?");
			choice4.setText("Food");
		}
		
		
		
	}
	public void RentRoom() {
		position = "RentRoom";
		positionPanelText.setText(position);
		money = money - 10;
		playerHP= playerHP + 10;
		moneyValueUpdater();
		hpLabelNumber.setText(""+playerHP);
		mainTextArea.setText("Amora:Its not the best but its home...sorta\n HP: + 10\nGold: -10");
		choice1.setText("Thank you");
		choice2.setText("");
		choice3.setText("");
		choice4.setText(">");
		
	}
	public void randomLead() {
		position = "Lead";
		positionPanelText.setText(position);
		leadChoice = new java.util.Random().nextInt(1);
		if(leadChoice <= 1) {
		 monsterGen();
		 
		mainTextArea.setText("Amora:There is a " + monster + " Making a mess take it out.");
		choice1.setText("Okay");
		choice2.setText("Nigga what?");
		choice3.setText("For that price?");
		choice4.setText(">"); 
		}
		
	}
	public void chase() {
		position = "chase";
		positionPanelText.setText(position);
		int slotNumber = 0;
		while(playerItem[slotNumber] != Empty && slotNumber<4) {
			slotNumber++;
		}
		
		if(playerItem[slotNumber]==Empty && gotFreeBread==false) {
			mainTextArea.setText("Chase:First time? Here have this\nyou recieved Bread");
			playerItem[slotNumber] = Bread;
			gotFreeBread= true;
			choice1.setText("Leave");
			choice2.setText("Buy a Heal Potion");
			choice3.setText("Buy Trolls Mallet");
			choice4.setText("");
		}else if(playerItem[slotNumber] != Empty && gotFreeBread==false) {
			mainTextArea.setText("Chase:Hmm...Seems you havent the space for free food...\n Come back later!");
		}else {
			if(purchase == 1 ) {
			mainTextArea.setText("Chase:Will that be all?\n");
			choice1.setText("Leave");
			choice2.setText("Buy a Heal Potion");
			choice3.setText("Buy Trolls Mallet");
			choice4.setText("");
			purchase = 0;
			}else {
				mainTextArea.setText("Chase:Hello");
				choice1.setText("Leave");
				choice2.setText("Buy a Heal Potion");
				choice3.setText("Buy Trolls Mallet");
				choice4.setText("");
			}
		
		}
		
		
	}
	public void buyHealPotion() {
		position = "HealPotionBuying";
		positionPanelText.setText(position);
		int slotNumber=0;
		int stack = 0;
		
			while(playerItem[stack] != HealingPotion  && stack<4) {
				System.out.println("Checking for Potion");
				stack++;
		}
			System.out.println(stack);
			while(playerItem[slotNumber] != Empty  && slotNumber<4) {
				System.out.println("Empty");
				slotNumber++;
		}
			
	
			
		if(playerItem[stack] != HealingPotion) {
			if(playerItem[slotNumber]==Empty && money>= HealingPotion.buyingPrice) {
				money = money - HealingPotion.buyingPrice;
				moneyValueUpdater();
					playerItem[slotNumber] = HealingPotion ;
					purchase = 1;
					chase();
					System.out.println("1111");
					chase();
				
			}else if((playerItem[slotNumber] != Empty) || (money< HealingPotion.buyingPrice)) {
			
				if(money< HealingPotion.buyingPrice){
					mainTextArea.setText("Chase:Hmm...Seems you havent the Gold for It...");
					choice1.setText("<");
					choice2.setText("");
					choice3.setText("");
					choice4.setText("");
				}else if(playerItem[slotNumber] != Empty) {
					mainTextArea.setText("Chase:Hmm...Seems you havent the space for It...");
					choice1.setText("<");
					choice2.setText("");
					choice3.setText("");
					choice4.setText("");
				}
				}
		}else  {
			//(playerItem[slotNumber]!=Empty)
			if(playerItem[stack] != HealingPotion && money>= HealingPotion.buyingPrice) {
				money = money - HealingPotion.buyingPrice;
				moneyValueUpdater();
					playerItem[slotNumber] = HealingPotion ;
					HealingPotion.stacking(HealingPotion.amount);
					System.out.println("Stacking " + HealingPotion.amount);
					purchase = 1;
					chase();
					System.out.println("2222");
					chase();
				
			}else if((playerItem[stack] != HealingPotion) || (money< HealingPotion.buyingPrice)) {
			
				if(money< HealingPotion.buyingPrice){
					mainTextArea.setText("Chase:Hmm...Seems you havent the Gold for It...");
					choice1.setText("<");
					choice2.setText("");
					choice3.setText("");
					choice4.setText("");
				}else if(playerItem[stack] != HealingPotion) {
					mainTextArea.setText("Chase:Hmm...Seems you havent the space for It...");
					choice1.setText("<");
					choice2.setText("");
					choice3.setText("");
					choice4.setText("");
				}
				}
		}
		
		
		
		}
	
	public void RiverSideTavern() {
		position = "RiverSideTavern";
		positionPanelText.setText(position);
		mainTextArea.setText("ag'ni: another wonderer, huh?");
		choice1.setText("Leave");
		choice2.setText("Buy a Drink (2 Gold)");
		choice3.setText("Tell me about Riverwood");
		choice4.setText("Buy Silver Dagger");
	}
	public void RiverwoodInfo(){
		position = "RiverwoodInfo";
		positionPanelText.setText(position);
		mainTextArea.setText("ag'ni: Whats there to tell? Riverwood might be a\nwhite washing job\nbut we learn to live with the stories\nperserve the culture");
		playerHP = playerHP -3;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void attackGuard(){
		position = "attackGuard";
		positionPanelText.setText(position);
		mainTextArea.setText("Guard: Hey don't be stupid!\n\nThe guard fought back and hit you hard.\n(You receive 3 damage)");
		playerHP = playerHP -3;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void crossRoad(){
		position = "crossRoad";
		positionPanelText.setText(position);
		mainTextArea.setText("You are at a crossroad.\nIf you go south, you will go back to the town.");
		choice1.setText("Go north");
		choice2.setText("Go east");
		choice3.setText("Go south");
		choice4.setText("Go west");
	}
	public void north(){
		position = "north";
		positionPanelText.setText(position);
		direction ="North";
		int randomEvent = new java.util.Random().nextInt(3);
		if(randomEvent <= 1) {
			forrestHouse();
		}else {
			helpWonderer();
		}
	}
	public void east(){
		position = "east";
		positionPanelText.setText(position);
		mainTextArea.setText("You walked into a forest and found a AR15!\n\n(You obtained a AR15");
		int slotNumber = 0;
		
		
		while(playerWeapon[slotNumber] != EmptyWeapon && slotNumber<3) {
			slotNumber++;
		}
		if(playerWeapon[slotNumber]==EmptyWeapon) {
			playerWeapon[slotNumber] = AR15 ;
			weaponSelector.setText(playerWeapon[slotNumber].name);
		}
		
		weaponSelector.setText(playerWeapon[slotNumber].name);
		choice1.setText("Go west");
		choice2.setText("Get Arm");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void GetArm() {
		int slotNumber=0;
		while(playerItem[slotNumber] != Empty && slotNumber<4) {
			slotNumber++;
		}
		if(playerItem[slotNumber]==Empty) {
			playerItem[slotNumber] = Arm ;
			helpWonderer();
		}
	}
	public void west(){
		position = "west";
		positionPanelText.setText(position);
		monsterGen();
		mainTextArea.setText("You encounter a " + monster + "!");
		choice1.setText("Fight");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	public void fight(){
		position = "fight";
		positionPanelText.setText(position);
		mainTextArea.setText("Monter HP: " + monsterHP + "\n\nWhat do you do?");
		choice1.setText("Attack With " + selectedWeapon);
		choice2.setText("Fire Spell");
		choice3.setText("Healing Spell");
		choice4.setText("Run");
	}
	public void fireSpell() {
		monsterHP = monsterHP - 20;
		
	}
	public void healspell() {
		healspell = 30;
		playerHP = playerHP + healspell ;
		hpLabelNumber.setText(""+playerHP);
	}
	public void playerAttack(){
		position = "playerAttack";
		positionPanelText.setText(position);
		int playerDamage;
		playerDamage = selectedWeaponDamage;
		mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");
		
		monsterHP = monsterHP - playerDamage;
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}
	public void monsterAttack(){
		position = "monsterAttack";
		positionPanelText.setText(position);
		
		monsterInt = new java.util.Random().nextInt(5);
		
		mainTextArea.setText("The " + monster + " attacked you and gave " + monsterDamage + " damage!");
		
		playerHP = playerHP - monsterDamage;
		hpLabelNumber.setText(""+playerHP);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");	
	}
	public void win(){
		position = "win";
		positionPanelText.setText(position);
		itemDrop();
		System.out.println(item);
		mainTextArea.setText("You defeated the " +  monster + "!\nThe " + monster + "dropped " + item +"\n\n(You obtained " + item + ")");
		playerLevel= playerLevel + .1;
		playerLevelText.setText(playerLevel+"");
		
		
		
		choice1.setText("continue");
		choice2.setText("Crossroads");
		choice3.setText("Healing Spell");
		choice4.setText("inventory");
		
	}
	public void lose(){
		position = "lose";
		positionPanelText.setText(position);
		
		mainTextArea.setText("You are dead!\n\n");
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void ending(){
		position = "ending";
		positionPanelText.setText(position);
		
		mainTextArea.setText("Guard: Oh you killed that goblin!?\nThank you so much. You are true hero!\nWelcome to our town!\n\n");
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void itemused(int slotNumber) {
		
		playerHP = playerHP + playerItem[slotNumber].healingValue;
		hpLabelNumber.setText(""+playerHP);
		
		playerItem[slotNumber] = Empty;
		
		itemButton1.setText(playerItem[0].name);
		itemButton1.setText(playerItem[1].name);
		itemButton1.setText(playerItem[2].name);
		itemButton1.setText(playerItem[3].name);
		itemButton1.setText(playerItem[4].name);
	}
	public void moneyValueUpdater() {
		moneyValue.setText(money + " Gold");
		moneyValue1.setText(money + "");
	}
	public void playerLevelUpdater() {
		playerLevelText.setText("Level: " + playerLevel);
	}
	public void buyMallet() {
		position = "buyAMallet";
		positionPanelText.setText(position);
		int slotNumber=0;
		while(playerWeapon[slotNumber] != EmptyWeapon && slotNumber<3) {
			slotNumber++;
		}
		if(playerWeapon[slotNumber]==EmptyWeapon && money>= Mallet.buyingPrice) {
			money = money - Mallet.buyingPrice;
			moneyValueUpdater();
			playerWeapon[slotNumber] = Mallet ;
			
			weaponSelector.setText(playerWeapon[slotNumber].name);
			selectedWeapon = playerWeapon[slotNumber].name;
			chase();
		}else if((playerWeapon[slotNumber] != EmptyWeapon) || (money< Mallet.buyingPrice)) {
			if(money< Mallet.buyingPrice){
				purchase = 0;
				mainTextArea.setText("Chase: Hmm...Seems you havent the Gold for It...");
			}else if(playerWeapon[slotNumber] != EmptyWeapon) {
				purchase = 0;
				mainTextArea.setText("Chase: Hmm...Seems you havent the space for It...");
			}
				choice1.setText("<");
				choice2.setText("");
				choice3.setText("");
				choice4.setText("");
		}
	}
	public void randomPassiveEvent() {
	}
	public void weaponSelected(int weaponSelected) {
		weaponDamage = playerWeapon[weaponSelected].weaponDamage;
		if(playerWeapon[weaponSelected] != EmptyWeapon) {
			weaponSelector.setText(playerWeapon[weaponSelected].name);
			System.out.println("Damage: "+ playerWeapon[weaponSelected].weaponDamage);
			selectedWeapon = playerWeapon[weaponSelected].name;
			selectedWeaponDamage = playerWeapon[weaponSelected].weaponDamage;
		}else if (playerWeapon[weaponSelected] == EmptyWeapon) {
			selectedWeapon = "None";
			selectedWeaponDamage = 0;
			weaponSelector.setText("None");
		}
		
		
		
	}
	public void forrestHouse() {
		position = "foundHouse";
		positionPanelText.setText(position);
		mainTextArea.setText("There is a house on the left... Door is locked but weak \n\n a clift hanging over a river to the right\n\n (Path continues forward)");
		choice1.setText("Continue " + direction );
		choice2.setText("Enter House");
		choice3.setText("");
		choice4.setText("Turn Back");
	}
	public void helpWonderer() {
		
		position = "helpWonderer";
		positionPanelText.setText(position);
		if(armChecked == 0) {
			mainTextArea.setText("You hear screaming as you aproch an opening in the trees\n\nWonderer: Hello! Hey have you seen my left arm?");
			choice1.setText("No i havent, (Continue " + direction + ")" );
			choice2.setText("Yes i have");
			choice3.setText("");
			choice4.setText("Back");
		}else if(armChecked == 1 && returnArm == "Yes") {
			helpWondererArm();
			
		}else if(armChecked == 1 && returnArm == "No") {
			mainTextArea.setText("You hear screaming as you aproch an opening in the trees\n\nWonderer: Hello! Hey have you seen my left arm?\nYou Dont have their arm");
		}
		
	}
	public void helpWondererArm() {
		position = "helpWondererArm";
		positionPanelText.setText(position);
		mainTextArea.setText("Wonderer:Thank You So much, This is all i have to repay you\n\n Gained 200 Gold!");
		int slotNumber = 0;
		while(playerItem[slotNumber] != Arm && slotNumber<4) {
			slotNumber++;
		}
		playerItem[slotNumber] = Empty;
		money = money + 200;
		moneyValueUpdater();
		choice1.setText("Go back" );
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void setWeapon() {
		
	}
	public void buySilverDagger() {
		int slotNumber=0;
		while(playerWeapon[slotNumber] != EmptyWeapon && slotNumber<3) {
			slotNumber++;
		}
		if(playerWeapon[slotNumber]==EmptyWeapon && money>= Silver_Dagger.buyingPrice) {
			money = money - Silver_Dagger.buyingPrice;
			moneyValueUpdater();
			playerWeapon[slotNumber] = Silver_Dagger ;
			
			weaponSelector.setText(playerWeapon[slotNumber].name);
			selectedWeapon = playerWeapon[slotNumber].name;
			RiverSideTavern();
		}else if((playerWeapon[slotNumber] != EmptyWeapon) || (money< Silver_Dagger.buyingPrice)) {
			if(money< Silver_Dagger.buyingPrice){
				purchase = 0;
				mainTextArea.setText("Ag'ni: Hmm...Seems you havent the Gold for It...");
			}else if(playerWeapon[slotNumber] != EmptyWeapon) {
				purchase = 0;
				mainTextArea.setText("Ag'ni: Hmm...Seems you havent the space for It...");
			}
				choice1.setText("<");
				choice2.setText("");
				choice3.setText("");
				choice4.setText("");
		}
	}
	public void checkForArm() {

		int slotNumber = 0;
		armChecked = 1;
		while(playerItem[slotNumber] != Arm && slotNumber<4) {
			slotNumber++;
		}
		if(playerItem[slotNumber] == Arm) {
			System.out.println("Success");
			returnArm= "Yes";
			helpWonderer();
			
		}else {
			System.out.println("Fail");
			returnArm= "No";
			helpWonderer();
		}
		
	}
	public void enterHouse() {
		position = "house1";
		positionPanelText.setText(position);
			mainTextArea.setText("You enter the seemingly rundown house, but notice its oddly\n in good order.\n\n"
					+ "To your left is a bed and a dresser and on your right \n is a  square table with a chair on either side."
					+ "\n straight ahead is a fireplace with what seems to be \n half a dead animal");
			choice1.setText("Look into chest" );
			choice2.setText("Inspect the bed");
			choice3.setText("sit at a chair");
			choice4.setText("Go Back");
		
	}
	public void openRanChest() {
		position = "randChest";
		positionPanelText.setText(position);
		int chestLvl;
		chestLvl = (int) (playerLevel);
		
		if(chestLvl <= 20) {
			
			int chestItemPointer = new java.util.Random().nextInt(3);
			
			if(chestItemPointer <= 1) {
				
				mainTextArea.setText("The chest is Empty!");
				
				playerLevel = (int) (playerLevel + .01);
				playerLevelUpdater();
				
				choice1.setText("" );
				choice2.setText("");
				choice3.setText("");
				choice4.setText("Go Back");
				
			}else if(chestItemPointer == 2) {
				
				int gold = new java.util.Random().nextInt(100);
				int goldAmount; 
				goldAmount = gold;
				
				playerLevel = (int) (playerLevel + .1);
				playerLevelUpdater();
				
				mainTextArea.setText("You found "+ goldAmount + " Gold!");
				
				
				money = money + goldAmount;
				moneyValueUpdater();
				
				choice1.setText("");
				choice2.setText("");
				choice3.setText("");
				choice4.setText("Go Back");
				
			}
			
		}
		
		int chestItemPointer = new java.util.Random().nextInt(1);
		
		
		
	}
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			createGameScreen();
		}
	}
	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String yourChoice = event.getActionCommand();
			
		switch(position){
			case "RiverwoodGate":
				switch(yourChoice){
				case "c1": 
					if(position == "RiverwoodGate"){
						talkGuard();
					}
					break;
				case "c2": attackGuard();break;
				case "c3": crossRoad();break;
				}
				break;
					case "talkGuard":
						switch(yourChoice){
						case "c1": crossRoad(); break;
						case "c2": RiverWood(); break;
						}
						break;
							case "attackGuard":
								switch(yourChoice){
									case "c1": RiverwoodGate(); break;
										}
										break;	
				
							case "RiverWood":
								switch(yourChoice){
								case "c1": RiverwoodGate(); break;
								case "c2": Amora();break;
								case "c3": RiverSideTavern(); break;
								case "c4": chase();break;
								}
								break;
							case "AmoraInn":
								switch(yourChoice){
								case "c1": RiverWood(); break;
								case "c2": RentRoom();break;
								case "c3": randomLead(); break;
								case "c4": buyBread();break;
								}
								break;
							case "RiverSideTavern":
								switch(yourChoice){
								case "c1": RiverWood(); break;
								case "c2": RiverSideTavern();break;
								case "c3": RiverwoodInfo(); break;
								case "c4": buySilverDagger();break;
								}
								break;
							case "RiverwoodInfo":
								switch(yourChoice){
								case "c1": RiverWood(); break;
								case "c2": RiverSideTavern();break;
								case "c3": RiverwoodInfo(); break;
								case "c4": west();break;
								}
								break;
							case "RentRoom":
								switch(yourChoice){
								case "c1": Amora(); break;
								case "c2": ;break;
								case "c3": ;break;
								case "c4": ;break;
								}
								break;
							case "Lead":
								switch(yourChoice){
								case "c1": monsterAttack(); break;
								case "c2": ;break;
								case "c3": ;break;
								case "c4": ;break;
								}
								break;	
							case "chase":
								switch(yourChoice){
								case "c1":RiverWood(); break;
								case "c2":buyHealPotion();break;
								case "c3":buyMallet();break;
								case "c4": ;break;
								}break;	
							case "HealPotionBuying":
								switch(yourChoice) {
								case "c1":chase();break;
								case "c2":;break;
								case "c3":;break;
								case "c4":;break;
								}break;	
							case "buyBread":
								switch(yourChoice) {
								case "c1":Amora(); break;
								case "c2":;break;
								case "c3":;break;
								case "c4":;break;
								}break;	
							case "buyAMallet":
								switch(yourChoice) {
								case "c1":chase(); break;
								case "c2":;break;
								case "c3":;break;
								case "c4":;break;
								}break;	
			case "crossRoad":
				switch(yourChoice){
				case "c1": north(); break;
				case "c2": east();break;
				case "c3": RiverwoodGate();break;
				case "c4": west();break;
				}break;	
			case "foundHouse":
				switch(yourChoice) {
				case "c1": north(); break;
				case "c2":enterHouse();break;
				case "c3":;break;
				case "c4":crossRoad();break;
				}break;
			case "house1":
				switch(yourChoice) {
				case "c1":openRanChest(); break;
				case "c2":;break;
				case "c3":;break;
				case "c4":crossRoad();break;
				}break;
			case "randChest":
				switch(yourChoice) {
				case "c1":; break;
				case "c2":;break;
				case "c3":;break;
				case "c4":enterHouse();break;
				}break;
			case "helpWonderer":
				switch(yourChoice) {
				case "c1": north(); break;
				case "c2":checkForArm();break;
				case "c3":;break;
				case "c4":crossRoad();break;
				}break;
			case "helpWondererArm":
				switch(yourChoice) {
				case "c1": crossRoad(); break;
				case "c2":;break;
				case "c3":;break;
				case "c4":;break;
				}break;
				
			case "north":
				switch(yourChoice){
				case "c1": crossRoad(); break;
				}
				break;
			case "east":
				switch(yourChoice){
				case "c1": crossRoad(); break;
				case "c2": GetArm();break;
				}
				break;
			case "west":
				switch(yourChoice){
				case "c1": fight(); break;
				case "c2": crossRoad(); break;
				}
				break;
			case "fight":
				switch(yourChoice){
				case "c1": playerAttack();break;
				case "c2": fireSpell(); break;
				case "c3": healspell(); break;
				case "c4": crossRoad(); break;
				}
				break;
			case "playerAttack":
				switch(yourChoice){
				case "c1": 
					if(monsterHP<1){
						win();
					}
					else{
						monsterAttack();
					}
					break;
				}
				break;
			case "monsterAttack":
				switch(yourChoice){
				case "c1": 
					if(playerHP<1){
						lose();
					}
					else{
						fight();
					}
					break;
				}
				break;
			case "win":
				switch(yourChoice){
				case "c1": west();
				}
				break;
			
		}
	}

		
	}
	public class InventoryHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String yourChoice = event.getActionCommand();
			int weaponDebug;
			switch(yourChoice){
			case "Inventory": 
				if(inventoryStatus == "Close") {
					choiceButtonPanel.setVisible(false);
					mainTextPanel.setVisible(false);
					inventoryPanel.setVisible(true);
					playerInfoPanel.setVisible(true);
					
					itemButton1.setText(playerItem[0].name);
					itemButton2.setText(playerItem[1].name);
					itemButton3.setText(playerItem[2].name);
					itemButton4.setText(playerItem[3].name);
					itemButton5.setText(playerItem[4].name);
					inventoryStatus = "Open";
				}else if(inventoryStatus == "Open") {
					inventoryPanel.setVisible(false);
					playerInfoPanel.setVisible(false);
					choiceButtonPanel.setVisible(true);
					mainTextPanel.setVisible(true);
					
					inventoryStatus = "Close";
				}
				break;
			case "weaponSelector":
				if(weaponOpen == "Close") {
					weaponSelectorPanel.setVisible(true);
				    mainTextPanel.setVisible(false);
				    weaponButton1.setText(playerWeapon[0].name);
				    weaponButton2.setText(playerWeapon[1].name);
				    weaponButton3.setText(playerWeapon[2].name);
				    weaponButton4.setText(playerWeapon[3].name);
				    weaponOpen = "true";
				}else if(weaponOpen == "true") {
					weaponSelectorPanel.setVisible(false);
				    mainTextPanel.setVisible(true);
				    weaponOpen = "Close";
				}
				
				break;
				
			case "item1":
				itemused(0);
				itemButton1.setText("");
				break;
			case "item2":
				itemused(1);
				itemButton2.setText("");
				break;
			case "item3":
				itemused(2);
				itemButton3.setText("");
				break;
			case "item4":
				itemused(3);
				itemButton4.setText("");
				break;
			case "item5":
				itemused(4);
				itemButton5.setText("");
				break;
			case "weapon1":
						weaponDebug = 0;
						weaponSelected(0);
						System.out.println(weaponDebug);
						weaponSelectorPanel.setVisible(false);
						mainTextPanel.setVisible(true);
						break;
			case "weapon2":
				weaponSelected(1);
				weaponDebug = 1;
				System.out.println(weaponDebug);
				weaponSelectorPanel.setVisible(false);
				mainTextPanel.setVisible(true);
				break;
			case "weapon3":
				weaponDebug = 2;
				weaponSelected(2);
				System.out.println(weaponDebug);
				weaponSelectorPanel.setVisible(false);
				mainTextPanel.setVisible(true);
				break;
			case "weapon4":
				weaponDebug = 3;
				weaponSelected(3);
				System.out.println(weaponDebug);
				weaponSelectorPanel.setVisible(false);
				mainTextPanel.setVisible(true);
				break;
			}
		}
	}
	
		}

			

