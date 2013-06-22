import java.io.IOException;


public class ListWorkStatus extends ConsoleStatus{

	private String firstMess;
	private String promptMess;
	private WorkList wlist;
	private WorkList selectedList;
	private PersonList plist;


	ListWorkStatus(String firstMess, String promptMess, boolean IsEndStatus, WorkList wlist, PersonList plist) {
		super(firstMess, promptMess, IsEndStatus);
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
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
				System.out.println("�w���ID�̏]�ƈ��͑��݂��܂���");
				System.out.println("�ē��͂��Ă��������B");
				displayFirstMess();
				return;
			}
			else {
				selectedList = wlist.searchByPersonID(i);
				selectedList.displayWithClient();

			}
		} catch( NumberFormatException e ) {
			System.out.println("���l�ɕϊ��ł��Ȃ��f�[�^�����͂���Ă��܂��B�ē��͂��Ă��������B");
			System.out.println("�ē��͂��Ă��������B");
			displayFirstMess();
			return;

		} catch (IOException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}

	}

	public ConsoleStatus getNextStatus( String s ) {
		return super.getNextStatus(" ");
	}


}
