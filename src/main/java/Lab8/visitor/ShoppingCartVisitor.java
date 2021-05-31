package Lab8.visitor;

interface ShoppingCartVisitor {

    int visit(Book book);

    int visit(Fruit fruit);
}