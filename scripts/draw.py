import pydot

with open('../tournament-data/32_ibdc20-optimized.txt',
          'r') as read_file:
    data = read_file.read()

for road in ['A', 'B', 'C']:
    graph = pydot.Dot(graph_type='digraph', rankdir='LR')
    seen = []
    for line in data.split("\n")[::-1]:
        if line.strip() == "":
            continue
        name, child1, child2 = line.split(" ")
        if road not in name:
            continue
        if child1 != '-':
            graph.add_node(pydot.Node(name, shape="square"))
            graph.add_node(pydot.Node(child1, shape="square"))
            edge = pydot.Edge(name, child1, label='w')
            graph.add_edge(edge)
        if child2 != '-':
            child_name = child2
            if child2 in seen:
                child_name = child2 + ' '
            seen.append(child2)
            graph.add_node(
                pydot.Node(child_name, shape="square", style="dotted"))
            edge = pydot.Edge(name, child_name, label='l')
            graph.add_edge(edge)

    graph.write_svg(f'{road}_road.svg')
