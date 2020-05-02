
public class SRMNode {
	private Repository repository;
	public SRMNode next;

	public SRMNode(Repository repository) {
		this.repository = repository;
		next = null;
	}

	public Repository getStudent() {
		return repository;
	}

}
