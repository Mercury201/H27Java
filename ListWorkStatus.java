import java.io.IOException;


public class ListWorkStatus extends ConsoleStatus{

	private String firstMess;
	private String promptMess;
	private WorkList wlist;
	private WorkList selectedList;
	private PersonList plist;


	ListWorkStatus(String firstMess, String promptMess, boolean IsEndStatus, WorkList wlist, PersonList plist) {
		super(firstMess, promptMess, IsEndStatus);
		// TODO 自動生成されたコンストラクター・スタブ
		this.firstMess = firstMess;
		this.promptMess = promptMess;
		this.wlist = wlist;
		this.plist = plist;
	}

	public void displayFirstMess(){
		plist.allNameIdDisplay();
		System.out.println(firstMess);

		try {
			String s = inputMessage();
			int i = Integer.parseInt( s );
			Person p = plist.get( i );
			if( p == null ){
				System.out.println("指定のIDの従業員は存在しません");
				System.out.println("再入力してください。");
				displayFirstMess();
				return;
			}
			else {
				selectedList = wlist.searchByPersonID(i);
				selectedList.displayWithClient();

			}
		} catch( NumberFormatException e ) {
			System.out.println("数値に変換できないデータが入力されています。再入力してください。");
			System.out.println("再入力してください。");
			displayFirstMess();
			return;

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public ConsoleStatus getNextStatus( String s ) {
		return super.getNextStatus(" ");
	}


}
