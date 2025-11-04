def call(Map args = [:]) {
    // Default parameters
    def defaults = [
        inventory: '/home/admin/PerformanceAnsible/Rushikesh/New_RVS_Integrity/inventory/test_execution_su.ini',
        playbook: '/home/admin/PerformanceAnsible/Rushikesh/New_RVS_Integrity/playbooks/Test_Execution.yml'
    ]

    // Merge user-supplied arguments with defaults
    def config = defaults + args

    // Build ansible command
    def cmd = """
        ansible-playbook -i ${config.inventory} \
        ${config.playbook} \
        -e '{
            "env_type": "${config.env_type}",
            "Build": "${config.Build}",
            "Release": "${config.Release}",
            "Threads": "${config.Threads}",
            "Threads1": "${config.Threads1}",
            "Threads2": "${config.Threads2}",
            "Rampup": "${config.Rampup}",
            "Iteration": "${config.Iteration}",
            "Duration": "${config.Duration}",
            "ServerIP": "${config.ServerIP}",
            "IP": "${config.Client_IP}",
            "Port": "${config.Port}",
            "Timeout": "${config.Timeout}",
            "Thinktime": "${config.Thinktime}",
            "NUM_Users": "${config.Total_Users}",
            "BaselineID": "${config.BaselineID}",
            "Summary": "${config.Summary}",
            "ScriptPath": "${config.ScriptPath}",
            "TestScript": "${config.TestScript}"
        }' \
        -vvv
    """

    // Run inside Jenkins shell
    sh cmd
}
