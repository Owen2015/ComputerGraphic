  public void traverseSceneGraph(SceneGraphObject sgo){
  Enumeration<?> enumeration;
  if(isGroup(sgo)){
  enumeration=((Group)sgo).getAllChildren();
  while(enumeration.hasMoreElements()){
  traverseSceneGraph((SceneGraphObject)enumeration.nextElement());
  }
  System.out.println("Group: "+sgo.getClass().getName().toString());
  }
  else
  System.out.println("Leaf: "+sgo.getClass().getName().toString());
  }

  public boolean isGroup(SceneGraphObject sgo){
  boolean isGroup=false;
  String sGroup="javax.media.j3d.Group";
  if(sgo.getClass().getName().toString().equals(sGroup)){
  isGroup=true;
  return isGroup;
  }

  Class<?> superClass=sgo.getClass().getSuperclass();
  while(superClass!=null){
  if(superClass.getName().toString().equals(sGroup))
  {
  isGroup=true;
  break;
  }
  superClass=superClass.getSuperclass();
  }
  return isGroup;

  }
