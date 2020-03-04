__command() -> 'this is the root command';


hello(who) -> (
    'HEMLO, ' + who + '!'
);


clone() -> (
    p = player();
    p_look = str('[%ff,%ff]', p ~ 'yaw', p ~ 'pitch');
    spawn('minecraft:zombie', p ~ 'pos', '{
        NoAI:1,
        ArmorItems:[{},{},{},{
            Count:1,
            id:player_head,
            tag:{SkullOwner:"' + p ~ 'name' + '"},
        }],
        CustomName:"\\"' + p ~ 'name' + '\\"",
        Rotation:' + p_look + ',
    }');
);
