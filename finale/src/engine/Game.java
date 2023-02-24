package engine;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.effects.*;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.CrowdControlAbility;
import model.effects.Effect;
import model.effects.Embrace;
import model.effects.Shield;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Cover;
import model.world.Hero;
import model.world.Villain;
import model.abilities.*;

public class Game {
	private Player firstPlayer;
	private Player secondPlayer;
	private boolean firstLeaderAbilityUsed;
	private boolean secondLeaderAbilityUsed;
	private Object[][] board;
	private static ArrayList<Champion> availableChampions;
	private static ArrayList<Ability> availableAbilities;
	private PriorityQueue turnOrder;
	///check final
	private final static int BOARDHEIGHT=5;
	private final static  int BOARDWIDTH=5;
	public Game(Player first, Player second) throws FileNotFoundException 
	{
		this.firstPlayer=first;
		this.secondPlayer=second;
		board =new Object[5][5];// added this
		turnOrder=new PriorityQueue(6);//added this
		//added this
		availableAbilities =new ArrayList<Ability>();
		availableChampions=new ArrayList<Champion>();
		//added
		placeChampions();
		placeCovers();
	
		
	}
	public static void loadAbilities(String filePath) throws IOException 
	{
		BufferedReader br=new BufferedReader(new FileReader(filePath));
		String line="";
		try {
			while((line=br.readLine())!=null) 
			{
				Ability temp=null;//must be null first
				String [] arr=line.split(",");
				if(arr[0].equals("CC")) 
				{
					String t=arr[5];
					AreaOfEffect t2=AreaOfEffect.valueOf(t);
					Effect e=null;
					switch(arr[7]) 
					{
					case "Shield": e=new Shield((Integer.parseInt(arr[8])));break;
					case "Silence": e=new Silence ((Integer.parseInt(arr[8]))); break;
					case "SpeedUp": e=new SpeedUp ((Integer.parseInt(arr[8]))); break;
					case "Stun": e=new Stun ((Integer.parseInt(arr[8]))); break;
					case "Shock": e=new Shock ((Integer.parseInt(arr[8]))); break;
					case "Root": e=new Root ((Integer.parseInt(arr[8]))); break;
					case "PowerUp": e=new PowerUp ((Integer.parseInt(arr[8]))); break;
					case "Embrace": e=new Embrace ((Integer.parseInt(arr[8]))); break;
					case "Dodge": e=new Dodge ((Integer.parseInt(arr[8]))); break;
					case "Disarm": e=new Disarm ((Integer.parseInt(arr[8]))); break;
					
					}
					 temp=new CrowdControlAbility(arr[1],(Integer.parseInt(arr[2])),(Integer.parseInt(arr[4])),(Integer.parseInt(arr[3])),t2,(Integer.parseInt(arr[6])),e);
				}
				if(arr[0].equals("DMG"))
						{
					String t=arr[5];
					AreaOfEffect t2=AreaOfEffect.valueOf(t);
					temp=new DamagingAbility(arr[1],(Integer.parseInt(arr[2])),(Integer.parseInt(arr[4])),(Integer.parseInt(arr[3])),t2,(Integer.parseInt(arr[6])),(Integer.parseInt(arr[7])));
					
						}
				if(arr[0].equals("HEL")) 
				{
					String t=arr[5];
					AreaOfEffect t2=AreaOfEffect.valueOf(t);
					temp=new HealingAbility(arr[1],(Integer.parseInt(arr[2])),(Integer.parseInt(arr[4])),(Integer.parseInt(arr[3])),t2,(Integer.parseInt(arr[6])),(Integer.parseInt(arr[7])));
				}
					
				availableAbilities.add(temp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void loadChampions(String filePath) throws IOException 
	 {
		 BufferedReader br=new BufferedReader(new FileReader(filePath));
			String line="";
				while((line=br.readLine())!=(null)) 
				{
					Champion temp=null;
					String arr[]=line.split(",");
					if(arr[0].equals("H")) 
					{
						temp=new Hero(arr[1],(Integer.parseInt(arr[2])),(Integer.parseInt(arr[3])),(Integer.parseInt(arr[4])),(Integer.parseInt(arr[5])),(Integer.parseInt(arr[6])),(Integer.parseInt(arr[7])));
						Ability a1=null;
						Ability a2=null;
						Ability a3=null;
						for(int i=0;i<availableAbilities.size();i++) 
						{
							if(availableAbilities.get(i).getName().equals(arr[8]))
								a1=availableAbilities.get(i);
							if(availableAbilities.get(i).getName().equals(arr[9]))
								a2=availableAbilities.get(i);
							if(availableAbilities.get(i).getName().equals(arr[10]))
								a3=availableAbilities.get(i);		
						}
					
						temp.getAbilities().add(a1);temp.getAbilities().add(a2);temp.getAbilities().add(a3);
					}
					if(arr[0].equals("A")) 
					{
						temp=new AntiHero(arr[1],(Integer.parseInt(arr[2])),(Integer.parseInt(arr[3])),(Integer.parseInt(arr[4])),(Integer.parseInt(arr[5])),(Integer.parseInt(arr[6])),(Integer.parseInt(arr[7])));
						Ability a1=null;
						Ability a2=null;
						Ability a3=null;
						for(int i=0;i<availableAbilities.size();i++) 
						{
							if(availableAbilities.get(i).getName().equals(arr[8]))
								a1=availableAbilities.get(i);
							if(availableAbilities.get(i).getName().equals(arr[9]))
								a2=availableAbilities.get(i);
							if(availableAbilities.get(i).getName().equals(arr[10]))
								a3=availableAbilities.get(i);		
						}
					
						temp.getAbilities().add(a1);temp.getAbilities().add(a2);temp.getAbilities().add(a3);
					}
					if(arr[0].equals("V")) {
						temp=new Villain(arr[1],(Integer.parseInt(arr[2])),(Integer.parseInt(arr[3])),(Integer.parseInt(arr[4])),(Integer.parseInt(arr[5])),(Integer.parseInt(arr[6])),(Integer.parseInt(arr[7])));
						Ability a1=null;
						Ability a2=null;
						Ability a3=null;
						for(int i=0;i<availableAbilities.size();i++) 
						{
							if(availableAbilities.get(i).getName().equals(arr[8]))
								a1=availableAbilities.get(i);
							if(availableAbilities.get(i).getName().equals(arr[9]))
								a2=availableAbilities.get(i);
							if(availableAbilities.get(i).getName().equals(arr[10]))
								a3=availableAbilities.get(i);		
						}
					
						temp.getAbilities().add(a1);temp.getAbilities().add(a2);temp.getAbilities().add(a3);
					}
					availableChampions.add(temp);
				
					
					
			}
		
	 }

	private void placeChampions() 
	{
		for(int i=0;i<firstPlayer.getTeam().size();i++) 
		{
			board[0][i+1]=firstPlayer.getTeam().get(i);
			firstPlayer.getTeam().get(i).setLocation(new Point(0,i+1));
			
		}
		for(int i=0;i<firstPlayer.getTeam().size();i++) 
		{
			board[4][i+1]=secondPlayer.getTeam().get(i);
			secondPlayer.getTeam().get(i).setLocation(new Point(4,i+1));
			
		}
	}
	private void placeCovers() 
	{
		Cover c1;
		int i=0;
		int x;
		int y;
		while(i<5) {
		 x=(int)(1+Math.random()*3);
		 y=(int)(Math.random()*5);
		if(board[x][y]==null) {
		c1=new Cover(x,y);
		board[x][y]=c1;
		i++;
		}
		}
	}
	

	
	
	
	public Player getFirstPlayer() {
		return firstPlayer;
	}
	public Player getSecondPlayer() {
		return secondPlayer;
	}
	public boolean isFirstLeaderAbilityUsed() {
		return firstLeaderAbilityUsed;
	}
	public boolean isSecondLeaderAbilityUsed() {
		return secondLeaderAbilityUsed;
	}
	public Object[][] getBoard() {
		return board;
	}
	public static ArrayList<Champion> getAvailableChampions() {
		return availableChampions;
	}
	public static ArrayList<Ability> getAvailableAbilities() {
		return availableAbilities;
	}
	public PriorityQueue getTurnOrder() {
		return turnOrder;
	}
	public static int getBoardheight() {
		
		return BOARDHEIGHT;
	}
	public static int getBoardwidth() {
		return BOARDWIDTH;
	}
	
}


