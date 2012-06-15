typedef struct 
{
  int value;
  Node * left;
  Node * right;
}Node;

void visitBylevel(Node * root ) 
{
  Vector<Node*> q = new Vector<Node>;
  q.push(root);
  while(!q.empty())
    {
      Node * node = q.get();
      if(q!=null) 
	{
	  visit(node);
	  if(node->left!=null)
	    {
	      q.push(node->left);
	    }
	  if(node->right!=null)
	    {
	      q.push(node->right);
	    }
	}
    }
}
