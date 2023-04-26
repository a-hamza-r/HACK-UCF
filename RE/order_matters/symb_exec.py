import angr

proj = angr.Project('order');
addr_main = proj.loader.find_symbol("main").rebased_addr
print(addr_main)
addr_target = addr_main + 666;
print(addr_target)
state = proj.factory.entry_state(addr=addr_main)
sm = proj.factory.simulation_manager(state)
sm.explore(find=addr_target)
while len(sm.found) == 0:
      sm.step()
if (len(sm.found) > 0):
    print("found!")
    found_input = sm.found[0].posix.dumps(0) # this is the stdin
    print(found_input)
    with open("input-crackme0x00", "wb") as fp:
        fp.write(found_input)

