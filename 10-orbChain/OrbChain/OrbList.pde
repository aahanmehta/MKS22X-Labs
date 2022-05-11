public class OrbList {
  OrbNode first, last;

  //create a fixed orb
  OrbList() {
    first = new FixedOrbNode(0, height/5);
    last = new FixedOrbNode(width, height/5);
    //link them to eachother
    first.next = last;
    last.prev = first;
  }

  /**
   *complete this method
   */
  void add(OrbNode orb) {
    //insert orb at the end of the list before the last node.
    OrbNode temp = last.prev;
    last.prev = orb;
    orb.next = last;
    orb.prev = temp;
    temp.next = orb;
  }
  void add(int xcor, OrbNode toBeAdded) {
    OrbNode shift = first;
    while (shift.x < xcor) {
      shift = shift.next;
    }
    toBeAdded.prev = shift.prev;
    (shift.prev).next = toBeAdded;
    shift.prev = toBeAdded;
    toBeAdded.next = shift;
  }

  OrbNode getNodeAt(int x, int y) {
    OrbNode current = first;
    boolean found = false;
    while (current != null && !found) {
      if (dist(x, y, current.x, current.y) <= 5) {
        if (current.x-current.radius<x && current.x+current.radius>x && current.y-current.radius<y && current.y+current.radius>y)
          return current;
      }
    }
    return null;
  }
  void delete(OrbNode target) {
    (target.next).prev = target.prev;
    (target.prev).next = target.next;
  }

  /**
   *complete this method
   *process all nodes by running move.
   */
  void processAll() {
    OrbNode current = first;
    //advance current to next until it is null, move() each of the nodes
    while (current != null) {
      current.move();
      current = current.next;
    }
  }
  /**
   *complete this method
   *Display all nodes by running their display().
   */
  void display() {
    OrbNode current = first;
    //advance current to next until it is null, display() each of the nodes
    while (current != null) {
      current.display();
      current = current.next;
    }
  }
}
