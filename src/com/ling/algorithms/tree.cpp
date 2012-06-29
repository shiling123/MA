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

Node * findLowestParent(Node* root, Node * child1, Node * child2) {
  if( root == NULL ){
    return NULL;
  }

  if(root == child1 || root == child2 ) {
    return root;
  }

  Node * left = findLowestParent(root->left,child1,child2);
  Node * right = findLowestParent(root->right, child1,child2);

  if( left == NULL ){
    return rigth;
  } else if( right == NULL ) {
    return left;
  } else {
    return root;
  }
}
